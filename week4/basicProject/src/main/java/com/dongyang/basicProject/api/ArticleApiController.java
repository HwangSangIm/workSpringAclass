package com.dongyang.basicProject.api;

import com.dongyang.basicProject.dto.ArticleDTO;
import com.dongyang.basicProject.entity.ArticleEntity;
import com.dongyang.basicProject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleApiController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/api/articles")
    public ResponseEntity create(@RequestBody ArticleDTO dto){
        articleService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body("good");
    }

    @GetMapping("/api/articles/{id}")
    public ArticleEntity show(@PathVariable Long id) {
        return articleService.show(id);
    }

    @GetMapping("/api/articles")
    public List<ArticleEntity> index(){
        return articleService.index();
    }

}
