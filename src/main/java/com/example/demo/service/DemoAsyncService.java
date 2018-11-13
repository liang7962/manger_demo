package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

public interface DemoAsyncService {

	@Async
     Future<String> doTaskOne() throws Exception;

	@Async
     Future<String> doTaskTwo() throws Exception;

	@Async
     Future<String> doTaskThree() throws Exception;
}
