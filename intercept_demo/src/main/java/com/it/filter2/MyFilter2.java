package com.it.filter2;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

public class MyFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("【Filter2】初始化*********************!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("【Filter2】业务判断");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("【Filter2】放行*********************************!");
    }

    @Override
    public void destroy() {

    }
}
