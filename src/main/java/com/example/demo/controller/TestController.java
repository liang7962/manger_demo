package com.example.demo.controller;

import com.example.demo.pojo.AdminRegister;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("test.do")
    public String toTest(){
        AdminRegister ar = testService.getAdminRegistert("0120180724000004");

        return ar.getMobileNo()+"wewe";
    }



}
