package com.dongyang.basicProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class FirstController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/h")
    public String hello(Model mo){
        mo.addAttribute("userName","황상임");
        return "hi";
    }
}
