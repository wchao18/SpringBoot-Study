package com.it.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author wangchao
 * @description 配置错误页面(如果配置了统一异常处理页面，这个配置需要去掉)
 * @date 2019/08/16 14:56
 */
//@Configuration
public class ErrorPageConfig {

   @Bean
   public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
       return new EmbeddedServletContainerCustomizer() {
           @Override
           public void customize(ConfigurableEmbeddedServletContainer container) {
               ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST,"/error-400.html");
               ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND,"/error-404.html");
               ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error-500.html");
               container.addErrorPages(error400Page,error404Page,error500Page);
           }
       };
   }
}
