package com.github.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2", loadOnStartup = 1)
public class ServletDemo2 implements Servlet {

    /**
     * 调用时机：默认情况下，Servlet被第一次调用的时候
     * 调用次数：1次
     *         *loadOnStartUp = 1的时候提前执行，不访问也被调用
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("我要被调用了~~~(init)");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 自动执行
        System.out.println("servlet hello world~~");
    }

    /**
     * 调用时机：当tomcat服务被关闭的时候执行
     * 调用次数：1次
     */
    @Override
    public void destroy() {
        System.out.println("我要被销毁了~~~(destroy)");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }


}
