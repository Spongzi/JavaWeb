package com.github.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo1");
        // 1. 使用request对象 获取请求数据
        String name = req.getParameter("name"); // url ? name=  zhangsan
        // 2. 使用request 设置响应数据
        resp.setHeader("content-type", "text/html;charset=utf-8");
        resp.getWriter().write("<h1>" + name + "你好!</h1>");
        resp.getWriter().write(req.getAttribute("密码").toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
