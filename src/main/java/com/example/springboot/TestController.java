package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test")
    public String test(){
        log.info("this main thread name [{}]", Thread.currentThread().getName());
        testService.test();
        return "test";
    }

}
