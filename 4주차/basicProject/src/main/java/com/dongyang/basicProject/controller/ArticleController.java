package com.dongyang.basicProject.controller;

import com.dongyang.basicProject.DTO.ArticleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "article/new";
    }

    @PostMapping("/articles/new")
    public String newArticleForm(ArticleDTO dto){
        System.out.println("title: " + dto.getTitle());
        System.out.println("contents: " + dto.getContents());
        // 3. DAO 생성해서 2번의 DTO 넘겨주기
        return "";
    }

}
