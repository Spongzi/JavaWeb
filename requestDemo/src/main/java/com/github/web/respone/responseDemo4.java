package com.github.web.respone;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字符数据：设置字符数据的响应体
 */
@WebServlet(name = "responseDemo4", value = "/resp4")
public class responseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 读取文件
        FileInputStream fileInputStream = new FileInputStream("F:\\图片\\小何同学.jpg");

        // 2. 获取字节输出流
        ServletOutputStream os = response.getOutputStream();

        // 3. 完成流的copy
        IOUtils.copy(fileInputStream, os);

        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
