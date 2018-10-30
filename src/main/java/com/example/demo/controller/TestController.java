package com.example.demo.controller;

import com.example.demo.component.ThreadTest;
import com.example.demo.component.ThreadTest2;
import com.example.demo.pojo.AdminRegister;
import com.example.demo.service.TestService;
import com.example.demo.util.two.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    /*异步线程测试*/
    @GetMapping("test2.do")
    public void test2() throws InterruptedException {
        ThreadTest threadTest1=new ThreadTest();
        Thread t = new Thread(threadTest1);
        Thread.sleep(3000);
        t.start();
        ThreadTest2 threadTest2=new ThreadTest2();
        Thread t2 = new Thread(threadTest2);
        t2.start();
    }
}
