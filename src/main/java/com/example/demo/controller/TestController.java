package com.example.demo.controller;

import com.example.demo.pojo.AdminRegister;
import com.example.demo.service.TestService;
import com.example.demo.util.two.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Configurable
@EnableScheduling
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("test.do")
    public String toTest(){
        AdminRegister ar = testService.getAdminRegistert("0120180724000004");

        return ar.getMobileNo()+"wewe";
    }

//    @Scheduled(cron = "0/5 * * * * *")
//    public void Task(){
//        LoggerUtils.info(getClass(),"定时任务来了>>>>>>>>>>>>>>>>>");
//    }

    @GetMapping("test1.do")
    public void test1(){
        AdminRegister adminRegister=new AdminRegister();
        adminRegister.setAccId("123456789");
        adminRegister.setMobileNo("13778945612");
        adminRegister.setRole("1");
        adminRegister.setInit("1");
        adminRegister.setStatus("1");
        adminRegister.setCtime(DateUtil.getyyyyMMddHHmmss());
        testService.addAdminRegistert(adminRegister);
    }



}
