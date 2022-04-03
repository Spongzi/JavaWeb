package com.github.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyHttpServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        // 根据请求方式不同，进行分别处理
        HttpServletRequest request = (HttpServletRequest)req;
        // 1. 获取请求方式
        String method = request.getMethod();
        // 2. 判断
        if ("GET".equals(method)) {
            // TODO GET方式的处理逻辑
            doGet(req, resp);
        } else if ("POST".equals(method)) {
            // TODO POST方式的处理逻辑
            doPost(req, resp);
        }
    }

    protected void doPost(ServletRequest req, ServletResponse resp) {
    }

    protected void doGet(ServletRequest req, ServletResponse resp) {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
