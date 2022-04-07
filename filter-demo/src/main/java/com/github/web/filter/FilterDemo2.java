package com.github.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/hello.jsp")
public class FilterDemo2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 放行前对request数据进行处理
        System.out.println("1.FileDemo...");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        // 放行后对response数据进行处理
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
