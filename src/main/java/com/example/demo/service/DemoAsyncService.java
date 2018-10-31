package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

public interface DemoAsyncService {

	@Async
    public Future<String> doTaskOne() throws Exception;

	@Async
    public Future<String> doTaskTwo() throws Exception;

	@Async
    public Future<String> doTaskThree() throws Exception;
}
