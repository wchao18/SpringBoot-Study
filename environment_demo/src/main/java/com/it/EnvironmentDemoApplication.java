package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置文件优先级：先properties后yml,yml会覆盖properties中相同的配置
 */
@SpringBootApplication
//propertySource只加载properties文件
@PropertySource(value = "classpath:custom.properties",encoding = "UTF-8")
public class EnvironmentDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnvironmentDemoApplication.class, args);
    }

}
