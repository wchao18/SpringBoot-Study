package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置文件优先级：-Dspring.profiles.active=prd, 由jar包外向jar包内进行寻找，优先加载带profile的，再加载不带profile的,
 * yml优先级大于properties
 */
@SpringBootApplication
//propertySource只加载properties文件
@PropertySource(value = {"classpath:custom.properties","classpath:application1.properties"},encoding = "UTF-8")
public class EnvironmentDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnvironmentDemoApplication.class, args);
    }

}
