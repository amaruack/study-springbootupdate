package com.example.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration(proxyBeanMethods = false)
@Configuration
public class TestConfig {

    @Bean
    public TestEntity testEntity(){
        return TestEntity.builder().build();
    }

}
