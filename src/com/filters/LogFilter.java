package com.filters;

import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {
    private String name = "";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        获取初始化参数
//        name是在web.xml中配置的
        this.name = filterConfig.getInitParameter("name");
        System.out.println("配置的名称：" + this.name);
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("配置的名称" + this.name);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("调用销毁方法");
        this.name = "";
    }
}
