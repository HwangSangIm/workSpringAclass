package com.dongyang.basicProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @GetMapping("/search")
    public String mainSearch(@RequestParam("mSearchForm") String keyword){
        System.out.println("메인 검색: "+keyword);
        return "";
    }
}
