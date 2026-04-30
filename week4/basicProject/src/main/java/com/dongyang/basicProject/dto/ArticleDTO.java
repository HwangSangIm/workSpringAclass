package com.dongyang.basicProject.dto;

import com.dongyang.basicProject.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    private Long id;
    private String title;
    private String contents;

    public ArticleEntity toEntity(){
      return new ArticleEntity(id , title , contents);
    }

}
