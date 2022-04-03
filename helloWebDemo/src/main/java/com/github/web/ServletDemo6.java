package com.github.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDemo6", value = {"/ServletDemo6", "/Demo6"})
public class ServletDemo6 extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = ServletDemo6.class.getName();
        System.out.println("哈哈哈，我是" + name);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
