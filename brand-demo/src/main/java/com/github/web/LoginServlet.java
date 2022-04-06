package com.github.web;

import com.github.pojo.User;
import com.github.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取账号密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 获取复选框数据
        String remember = request.getParameter("remember");

        User user = service.login(username, password);

        // 判断
        if (user != null) {
            // 登录成功, 存储数据到session中
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // 判断用户是否选择"记住我"
            if ("1".equals(remember)) {
                // 勾选了，发送Cookie

                // 创建cookie
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);

                // 设置cookie的存活时间
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);

                // 发送cookie
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            request.getRequestDispatcher("/demo1").forward(request, response);
        } else {
            // 登录失败，跳转到login.jsp
            request.setAttribute("login_msg", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
