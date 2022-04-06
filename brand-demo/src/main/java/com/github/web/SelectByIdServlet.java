package com.github.web;

import com.github.pojo.Brand;
import com.github.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收id
        String id = req.getParameter("id");
        // 2. 调用service查询
        Brand brand = service.selectById(Integer.parseInt(id));
        // 3. 存储到request
        req.setAttribute("brand", brand);
        // 4. 转发到update.jsp
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
