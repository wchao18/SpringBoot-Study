package com.it.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author wangchao
 * @description 全局跨域设置
 * @date 2019/09/05 15:31
 */
//@Configuration
public class GlobalCorsConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowedOrigins("http://127.0.0.1:80","http://127.0.0.1:8082")
                .allowedMethods("*");
    }
}
