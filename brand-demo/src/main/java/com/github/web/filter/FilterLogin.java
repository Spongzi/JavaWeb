package com.github.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterLogin", urlPatterns = "/*")
public class FilterLogin implements Filter {
    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 强转
        HttpServletRequest req = (HttpServletRequest) request;

        // 判断访问的资源路径是否和登录注册相关
        String[] urls = {"/login.jsp", "/imgs/", "/css/", "/loginServlet", "/register.jsp", "registerServlet", "/checkCodeServlet"};

        // 获取当前访问的路径
        String url = req.getRequestURL().toString();

        for (String u : urls) {
            if (url.contains(u)) {
                chain.doFilter(req, response);
                return;
            }
        }

        // 先拦截， 判断是否登录，判断session
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            req.setAttribute("login_msg", "您尚未登录！");
            req.getRequestDispatcher("/login.jsp").forward(req, response);
            return;
        }
        chain.doFilter(req, response);
    }
}
