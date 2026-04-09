package com.dongyang.basicProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ArticleEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String contents;

    public ArticleEntity() {
    }

    public ArticleEntity(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
