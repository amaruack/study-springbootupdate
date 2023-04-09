package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {

    @Async
    public void test() {

        log.info("thread name [{}]", Thread.currentThread().getName());
    }

}
