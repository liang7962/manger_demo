package com.example.demo.service;

import com.example.demo.pojo.AdminRegister;
import com.example.demo.util.two.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

@Service
public class DemoAsyncServiceImpl implements DemoAsyncService {

	public static Random random =new Random();

    @Autowired
    private TestService testService;

    @Async
    public Future<String> doTaskOne() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));

        AdminRegister adminRegister=new AdminRegister();
        adminRegister.setAccId("1123456789");
        adminRegister.setMobileNo("13778945612");
        adminRegister.setRole("1");
        adminRegister.setInit("1");
        adminRegister.setStatus("1");
        adminRegister.setCtime(DateUtil.getyyyyMMddHHmmss());
        testService.addAdminRegistert(adminRegister);

        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        System.out.println("完成任务一，名称：" + Thread.currentThread().getName());
        return new AsyncResult<>("任务一完成");
    }

    @Async
    public Future<String> doTaskTwo() throws Exception {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));

        AdminRegister adminRegister=new AdminRegister();
        adminRegister.setAccId("1234567890");
        adminRegister.setMobileNo("13778945612");
        adminRegister.setRole("1");
        adminRegister.setInit("1");
        adminRegister.setStatus("1");
        adminRegister.setCtime(DateUtil.getyyyyMMddHHmmss());
        testService.addAdminRegistert(adminRegister);

        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
        System.out.println("完成任务二，名称：" + Thread.currentThread().getName());
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String> doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));

        AdminRegister adminRegister=new AdminRegister();
        adminRegister.setAccId("0123456789");
        adminRegister.setMobileNo("13778945612");
        adminRegister.setRole("1");
        adminRegister.setInit("1");
        adminRegister.setStatus("1");
        adminRegister.setCtime(DateUtil.getyyyyMMddHHmmss());
        testService.addAdminRegistert(adminRegister);

        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        System.out.println("完成任务三，名称：" + Thread.currentThread().getName());
        return new AsyncResult<>("任务三完成");
    }
	
}
