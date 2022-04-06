package com.github.web;

import com.github.pojo.User;
import com.github.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 注册用户
 */
@WebServlet(name = "RegisterServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        // 2. 创建一个对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        HttpSession session = request.getSession();

        // 3. 调用
        boolean register = service.register(user);

        // 4. 转发到登录页面
        if (register) {
            if (session.getAttribute("checkCode").equals(checkCode)) {
                request.setAttribute("register_msg", "注册成功，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                request.setAttribute("register_msg", "验证码错误");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } else {
            // 注册失败，跳转到注册页面
            request.setAttribute("register_msg", "用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
