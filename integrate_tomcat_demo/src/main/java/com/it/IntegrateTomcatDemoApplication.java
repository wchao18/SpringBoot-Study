package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * PS:使用外部Tomcat部署访问的时候，application.properties(或者application.yml)中的配置失效！！
 */
@SpringBootApplication
public class IntegrateTomcatDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(IntegrateTomcatDemoApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(IntegrateTomcatDemoApplication.class);
    }
}
