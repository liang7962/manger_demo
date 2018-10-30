package com.example.demo.component;

import org.springframework.scheduling.annotation.Async;

public class ThreadTest implements Runnable{

    @Override
    @Async
    public void run() {
        System.out.println("ThreadTest1开始》》》》》》》》》》》》》》》》》");
    }
}
