package com.github.web.respone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字符数据：设置字符数据的响应体
 */
@WebServlet(name = "responseDemo3", value = "/resp3")
public class responseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 响应字符数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        response.setHeader("content-type", "text/html");
        writer.write("aaa");
        writer.write("你好");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
