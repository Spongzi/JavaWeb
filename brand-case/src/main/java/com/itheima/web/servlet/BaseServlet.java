package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 替换HttpServlet
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求路径
        String requestURI = req.getRequestURI();

        // 2. 获取最后一段路径， 方法名
        int index = requestURI.lastIndexOf('/');
        String methodName = requestURI.substring(index + 1);

        // 3. 执行方法
        // 此处this代表了BrandServlet
        // 3.1 获取BrandServlet字节码对象
        Class<? extends BaseServlet> cls = this.getClass();
        try {
            // 3.2 获取方法method
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 3.3 执行方法
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
