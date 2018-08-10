package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("login.do")
    public String toLogin(){
        return "framework/login";
    }

    @GetMapping("index.do")
    public String toIndex(){
        return "framework/index";
    }

    @RequestMapping(value = "/index_content")
    public String indexContent()
    {
        return "/framework/index_content";
    }
}
