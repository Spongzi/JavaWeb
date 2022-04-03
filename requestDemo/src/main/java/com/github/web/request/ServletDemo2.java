package com.github.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 请求转发！
 */
@WebServlet(name = "ServletDemo2", value = "/demo2")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo2");

        // 设置一个键值
        request.setAttribute("密码", "123456");
        // 请求转发
        request.getRequestDispatcher("/demo1").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
