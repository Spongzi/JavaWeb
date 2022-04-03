package com.github.web.respone;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "responseDemo1", value = "/resp1")
public class responseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1...");

        // 重定向
        /*// 要设置响应状态码
        response.setStatus(302);
        // 设置响应头
        response.setHeader("Location", "/request/resp2");*/

        // 简化写法

        // 动态获取目录虚拟路径 --> 用来降低代码耦合性
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
