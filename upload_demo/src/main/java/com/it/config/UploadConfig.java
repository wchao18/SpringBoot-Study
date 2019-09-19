package com.it.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;


/**
 * @author wangchao
 * @description 上传文件配置
 * @date 2019/09/12 15:51
 */
@Configuration
public class UploadConfig {

    @Bean
    public MultipartConfigElement multipartConfig(){
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
        multipartConfigFactory.setLocation("/");
        multipartConfigFactory.setMaxFileSize("20MB");
        multipartConfigFactory.setMaxRequestSize("50MB");
        return multipartConfigFactory.createMultipartConfig();
    }
}
