package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(value = {"com.it.servlet3","com.it.filter3"})
public class InterceptDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterceptDemoApplication.class, args);
    }

}
