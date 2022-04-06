package com.github.web.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "com.github.web.cookie.AServlet", value = "/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 发送Cookie
        // 1. 创建Cookie对象
//        Cookie cookie = new Cookie("username", "zhangsan");
        String value = "张三";
        value = URLEncoder.encode(value, "UTF-8");
        Cookie cookie = new Cookie("username", value);

        // 2. 设置存活时间 1周7天 --> 转化为秒
        cookie.setMaxAge(60*60*24*7);

        // 2. 发送Cookie, response
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
