package com.it.servlet2;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchao
 * @description servlet2.0配置
 * @date 2020/06/08 14:25
 */
@Configuration
public class ServletConfig {

    //@Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new MyServlet2(),"/servlet2");
    }
}
