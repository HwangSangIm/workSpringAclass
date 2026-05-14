package com.dongyang.basicProject.service;

import com.dongyang.basicProject.dto.ArticleDTO;
import com.dongyang.basicProject.entity.ArticleEntity;
import com.dongyang.basicProject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public ArticleEntity show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public List<ArticleEntity> index(){
        return (List<ArticleEntity>)articleRepository.findAll();
    }

    public void create(ArticleDTO dto){
        ArticleEntity ae = dto.toEntity();
        articleRepository.save(ae);
    }

    public void delete(Long id){
        articleRepository.deleteById(id);
    }

    @Transactional
    public List<ArticleEntity> createArticles(List<ArticleDTO> dtos){
//        List<ArticleEntity> ArticleList = new ArrayList<>();
//        for (int i = 0 ; i < dtos.size() i++) {
//            ArticleDTO dto = dtos.get(i);
//            ArticleList.add(dto.toEntity());
//        }
//      List<ArticleEntity> ArticleList=dtos.stream().map(dto -> dto.toEntity()).collect(Collectors.toList());
        List<ArticleEntity> ArticleList=dtos.stream().map(ArticleDTO::toEntity).toList();

        List<ArticleEntity> articleResult = (List<ArticleEntity>) articleRepository.saveAll(ArticleList);
        try{
            articleRepository.findById(-1L).orElseThrow();
        } catch (Exception e) {
            throw new IllegalArgumentException("삽입 실패!");
        }
        return articleResult;
    }

    public void update(Long id , ArticleDTO dto){
        ArticleEntity article = dto.toEntity();
        ArticleEntity target = articleRepository.findById(id).orElse(null);
        target.patch(article);
        articleRepository.save(target);
    }
}
