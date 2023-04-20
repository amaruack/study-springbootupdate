package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    TestRepository testRepository;

    @Autowired
    ApplicationAvailability applicationAvailability;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/hello")
    public String hello(){
        return "application " + applicationAvailability.getLivenessState() + applicationAvailability.getReadinessState();
    }

    @GetMapping("/readiness/block")
    public String blockEvent(){
        AvailabilityChangeEvent.publish(applicationEventPublisher, this, ReadinessState.REFUSING_TRAFFIC);
        return "block";
    }

    @GetMapping("/liveness/broken")
    public String breakEvent(){
        AvailabilityChangeEvent.publish(applicationEventPublisher, this, LivenessState.BROKEN);
        return "broken";
    }

    @GetMapping("/test")
    public String test(){
        DataSize te  ;
        log.info("this main thread name [{}]", Thread.currentThread().getName());
        testService.test();
        return "test";
    }

    @GetMapping("/find-all")
    public String findAll(){
        Iterable<TestEntity> all = testRepository.findAll();
        return "test";
    }

}
