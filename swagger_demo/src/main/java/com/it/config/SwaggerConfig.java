package com.it.config;

import com.google.common.base.Predicates;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/28 11:11
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //页面访问地址：http://127.0.0.1:8080/swagger-ui.html
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.it.controller"))
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))// 错误路径不监控
                .paths(PathSelectors.regex("/.*")).build();// 对根下所有路径进行监控
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("SpringBoot整合swagger").description("更多内容请联系123456@qq.com")
                .contact(getContact()).version("1.0.0").build();
    }

    private Contact getContact() {
        return new Contact("小王", "", "");
    }


}
