package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 配置文件优先级：先properties后yml
 */
@SpringBootApplication
public class EnvironmentDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnvironmentDemoApplication.class, args);
    }

}
