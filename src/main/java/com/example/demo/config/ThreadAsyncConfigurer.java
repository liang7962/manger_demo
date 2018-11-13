package com.example.demo.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
/**
 * ①利用＠EnableAsync 注解开启异步任务支持。
 * ②配置类实现AsyncConfigurer 接口并重写getAsyncExecutor 方法，并返回一个
 * ThreadPoolTaskExecutor ，这样我们就获得了一个基于线程池TaskExecutor。
 * Author: 王俊超      主要针对ThreadPoolTaskScheduler线程池
 * Date: 2017-07-11 07:57
 * All Rights Reserved !!!
 */
@Configuration
//@ComponentScan("com.example.demo.component")
@EnableAsync
public class ThreadAsyncConfigurer implements AsyncConfigurer{

        @Bean
        public Executor getAsyncExecutor() {
            ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
            //设置核心线程数
            threadPool.setCorePoolSize(10);
            //设置最大线程数
            threadPool.setMaxPoolSize(100);
            //线程池所使用的缓冲队列
            threadPool.setQueueCapacity(10);
            //等待任务在关机时完成--表明等待所有线程执行完
            threadPool.setWaitForTasksToCompleteOnShutdown(true);
            // 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
            threadPool.setAwaitTerminationSeconds(60);
            //  线程名称前缀
            threadPool.setThreadNamePrefix("MyAsync-");
            // 初始化线程
            threadPool.initialize();
            return threadPool;
        }

        @Override
        public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
            return null;
        }
}
