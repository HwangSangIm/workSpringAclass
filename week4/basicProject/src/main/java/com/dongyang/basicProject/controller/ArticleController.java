package com.dongyang.basicProject.controller;

import com.dongyang.basicProject.dto.ArticleDTO;
import com.dongyang.basicProject.entity.ArticleEntity;
import com.dongyang.basicProject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping("/articles/")
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/new")
    public String newArticleForm(){
        return "article/new";
    }

    @PostMapping("/new")
    public String newArticleForm(ArticleDTO dto){
//        System.out.println("title: " + dto.getTitle());
//       System.out.println("contents: " + dto.getContents());
        // 1. dto의 값 -> ArticleEntity 객체
        // ArticleEntity ae = new ArticleEntity(null, dto.getTitle(), dto.getContents());
        ArticleEntity ae = dto.toEntity();
        // 2. ArticleRepository의 save( ) 호출
        articleRepository.save(ae);
        return "";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        ArticleEntity at =articleRepository.findById(id).orElse(null);
        model.addAttribute("showResult",at);
        return "article/show";
    }
}
