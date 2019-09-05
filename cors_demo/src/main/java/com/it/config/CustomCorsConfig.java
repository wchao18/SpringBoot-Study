package com.it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author wangchao
 * @description 自定义跨域请求(thymeleaf-demo的静态文件调用本服务)
 * @date 2019/09/05 14:30
 */
//@Component
public class CustomCorsConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
       return new WebMvcConfigurerAdapter() {
           @Override
           public void addCorsMappings(CorsRegistry registry) {
               //1.返回域是前端的地址
               //2.请求方式必须大写
               //3.跨域cookie的问题：域名必须精确
               registry.addMapping("/api/**").allowedOrigins("http://127.0.0.1:80","http://127.0.0.1:8082")
                       .allowedMethods("GET", "POST", "DELETE", "OPTIONS", "PUT","HEAD");
               //registry.addMapping("/api/**").allowedOrigins("*");
           }
       };
    }
}
