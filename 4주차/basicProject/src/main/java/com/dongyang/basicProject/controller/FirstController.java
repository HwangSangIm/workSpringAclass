package com.dongyang.basicProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class FirstController {
    @GetMapping("/home")
    public String index(){
        return "index";
    }
}
