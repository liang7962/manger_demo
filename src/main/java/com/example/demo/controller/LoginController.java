package com.example.demo.controller;

import com.example.demo.util.IPUtil;
import com.example.demo.util.LoggerUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("login.do")
    public String toLogin(){
        return "framework/login";
    }

    @GetMapping("index.do")
    public String toIndex(HttpServletRequest request){
        LoggerUtils.info(getClass(), "ip>>>>>>>>>>>>"+IPUtil.getIpAddress(request));
        return "framework/index";
    }

    @RequestMapping(value = "/index_content")
    public String indexContent()
    {
        return "/framework/index_content";
    }
}
