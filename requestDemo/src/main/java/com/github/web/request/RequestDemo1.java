package com.github.web.request;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // POST解决乱码！ GET不可以解决乱码问题
        req.setCharacterEncoding("utf-8");
        // 1. getMethod 获取请求方式
        String method = req.getMethod();
        System.out.println("获取方法是" + method);
        // 2. getContextPath: 获取拟目录(项目访问路径)
        String contextPath = req.getContextPath();
        System.out.println("项目访问路径是：" + contextPath);
        // 3. getRequestURL() 获取URL(统一资源定位器)
        String requestURL = String.valueOf(req.getRequestURL());
        System.out.println("访问的URL是" + requestURL);
        // 4. getRequestURI 获取URI
        String requestURI = req.getRequestURI();
        System.out.println("URI地址：" + requestURI);
        // 5. getQueryString 获取参数
        // tomcat默认使用的默认字符集是ISO-8859-1
        // 解决GET乱码问题！
        String queryString = req.getQueryString();
        byte[] bytes = queryString.getBytes(StandardCharsets.ISO_8859_1);
        queryString = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("获取的参数内容是" + queryString);
        // 6. 获取请求头的消息
        String header = req.getHeader("User-Agent");
        System.out.println("User-Agent的信息是：" + header);

        String username = req.getParameter("username");
        System.out.println("用户名是：" + username);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Post 请求体：请求参数

        this.doGet(req, resp);
    }
}
