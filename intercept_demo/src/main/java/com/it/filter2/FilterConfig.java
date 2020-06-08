package com.it.filter2;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/06/08 17:21
 */
@Configuration
public class FilterConfig {

    //@Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter2());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    /**
     * PS:方式1:只有当spring.http.encoding.enable=flase才会生效
     *    方式2:
     *    spring.http.encoding.charset=UTF-8
     *    spring.http.encoding.enabled=true
     *    spring.http.encoding.force=true
     *
     */
    //@Bean
    public FilterRegistrationBean charsetFilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        filterRegistrationBean.setFilter(characterEncodingFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
