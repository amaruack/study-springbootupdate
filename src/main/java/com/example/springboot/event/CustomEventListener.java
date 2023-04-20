package com.example.springboot.event;

import com.example.springboot.TestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {

    @Autowired
    ApplicationAvailability applicationAvailability;

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    TestConfiguration testConfiguration;

    @Value("${my.message}")
    String message;

    @Async
    @EventListener
    public void onStateChanged(AvailabilityChangeEvent<ReadinessState> readiness) throws InterruptedException {
        System.out.println("changed " + readiness.getState());
        if (readiness.getState() == ReadinessState.REFUSING_TRAFFIC) {
            Thread.sleep(20000);
            AvailabilityChangeEvent.publish(applicationEventPublisher, this, ReadinessState.ACCEPTING_TRAFFIC);
        }
    }

}
