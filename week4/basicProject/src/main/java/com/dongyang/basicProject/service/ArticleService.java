package com.dongyang.basicProject.service;

import com.dongyang.basicProject.dto.ArticleDTO;
import com.dongyang.basicProject.entity.ArticleEntity;
import com.dongyang.basicProject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
