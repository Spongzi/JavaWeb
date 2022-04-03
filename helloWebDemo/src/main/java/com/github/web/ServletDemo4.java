package com.github.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet("/demo4")
public class ServletDemo4 implements Servlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        // 自动执行
        System.out.println("servlet hello world~~");
        // 根据请求方式不同，进行分别处理
        HttpServletRequest request = (HttpServletRequest)req;
        // 1. 获取请求方式
        String method = request.getMethod();
        // 2. 判断
        if ("GET".equals(method)) {
            // TODO GET方式的处理逻辑
        } else if ("POST".equals(method)) {
            // TODO POST方式的处理逻辑
        }
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
