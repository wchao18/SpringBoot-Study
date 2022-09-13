package com.it.skywalking;

import com.it.config.EnableAutoConfigurationTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfigurationTest
public class SkywalkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkywalkingApplication.class, args);
    }

}
