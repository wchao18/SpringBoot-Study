package com.it.filter3;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/06/08 16:42
 */
@WebFilter(urlPatterns = "/*")
public class MyFilter3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("【Filter3】初始化**********************！");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("【Filter3】业务判断");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("【Filter3】放行**********************************！");
    }

    @Override
    public void destroy() {
        System.out.println("【Filter3】销毁***************************！");
    }
}
