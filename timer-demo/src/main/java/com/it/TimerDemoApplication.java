package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TimerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimerDemoApplication.class, args);
    }

}
