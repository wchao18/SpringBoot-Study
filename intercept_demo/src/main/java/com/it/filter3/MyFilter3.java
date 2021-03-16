package com.it.filter3;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Order(1)//指定过滤器的执行顺序,值越大越靠后执行
@WebFilter(urlPatterns = "/*") //注解方式需要在启动类上加@ServletComponentScan
public class MyFilter3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("【Filter3】初始化**********************！");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("【Filter3】业务判断");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("【Filter3】放行**********************************！");
    }

    @Override
    public void destroy() {
        System.out.println("【Filter3】销毁***************************！");
    }
}
