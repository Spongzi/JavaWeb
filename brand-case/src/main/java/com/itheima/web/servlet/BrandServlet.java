package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandServiceImpl service = new BrandServiceImpl();

    /*public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建一个Brands用来接收对象
        List<Brand> brands = service.selectAll();

        // 序列化
        String jsonString = JSON.toJSONString(brands);

        // 返回给页面
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }*/

    public void addBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置中文格式
        request.setCharacterEncoding("utf-8");
        // 1. 获取json数据(使用读取整行的形式)
        String readLine = request.getReader().readLine();

        // 2. 将json数据转化为对象
        Brand brand = JSON.parseObject(readLine, Brand.class);

        // 3. 将数据添加至数据库
        service.add(brand);

        // 4. 如果成功返回数据
        response.getWriter().write("success");
    }

    public void deleteBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取id
        String id = request.getParameter("id");

        // 2. 调用方法
        service.deleteById(Integer.parseInt(id));

        // 3. 返回数据，如果成功
        response.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取数据
        String readLine = request.getReader().readLine();

        // 2. 反序列化
        Integer[] ids = JSON.parseObject(readLine, Integer[].class);
        System.out.println(Arrays.toString(ids));

        // 4. 调用函数
        service.deleteByIds(ids);

        // 5. 返回成功的数据
        response.getWriter().write("success");
    }

    public void modifyBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收参数
        String readLine = request.getReader().readLine();

        // 2. JSON 结构化
        Brand brand = JSON.parseObject(readLine, Brand.class);

        // 3. 判断是否有这个数据
        if (service.selectById(brand.getId()) == null) {
            response.getWriter().write("failed");
            return;
        }

        // 4. 调用修改函数
        service.modifyById(brand);

        // 5. 返回成功指令
        response.getWriter().write("success");
    }

    /**
     * 分页查询
     */
    /*public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收 当前页面和每页展示条数 url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        // 调用service
        PageBean<Brand> brandPageBean = service.selectByPage(currentPage, pageSize);

        // 序列化
        String jsonString = JSON.toJSONString(brandPageBean);

        // 返回给页面
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }*/

    /**
     * 条件查询
     */
    public void selectByCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 1. 接收 当前页面和每页展示条数 url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        // 2. 接收条件
        String readLine = request.getReader().readLine();

        // 3. 反序列化
        Brand brand = JSON.parseObject(readLine, Brand.class);
        // 封装一下brandName和companyName
        if (brand.getBrandName() != null && !"".equals(brand.getBrandName())){
            brand.setBrandName("%" + brand.getBrandName() + "%");
        }
        if (brand.getCompanyName() != null && !"".equals(brand.getCompanyName())){
            brand.setCompanyName("%" + brand.getCompanyName() + "%");
        }
        System.out.println(brand);

        // 得到结果
        PageBean<Brand> brandPageBean = service.selectByCondition(currentPage, pageSize, brand);

        // 再去序列化
        String jsonString = JSON.toJSONString(brandPageBean);

        // 返回给页面
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
