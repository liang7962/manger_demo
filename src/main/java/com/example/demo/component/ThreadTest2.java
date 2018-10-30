package com.example.demo.component;

import org.springframework.scheduling.annotation.Async;

public class ThreadTest2 implements Runnable{

    @Override
    @Async
    public void run() {
        System.out.println("ThreadTest2开始》》》》》》》》》》》》》》》》》");
    }
}
