package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@EnableAsync
@EnableScheduling
@SpringBootApplication
@ConfigurationPropertiesScan //이걸 했을때의 장점 , Immutable configurationProperties 지원
public class SpringBootV2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootV2Application.class, args);
    }

    @Scheduled(fixedDelay = 2000)
    public void Scheduled(){
        log.info("this main thread name [{}]", Thread.currentThread().getName());
    }

}
