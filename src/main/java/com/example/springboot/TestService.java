package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Async
    public void test() {
        log.info("thread name [{}]", Thread.currentThread().getName());
    }

    @PostConstruct
    public void init() {
        testRepository.save(TestEntity.builder()
                .title("title")
                .name("name")
                .build());
    }

}
