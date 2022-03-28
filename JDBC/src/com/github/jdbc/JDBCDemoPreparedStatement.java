package com.github.jdbc;

import org.testng.annotations.Test;

import java.sql.*;

public class JDBCDemoPreparedStatement {
    @Test
    public void TestUserLogin() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name = "zhangsan";
        String pwd = "1234";

        // 3. 写执行数据库代码
        String sqlStr = "select * from tb_user where user = ? and password = ?;";
        // 4. 获取对象
        PreparedStatement preparedStatement = conn.prepareStatement(sqlStr);
        // 5. 执行语句
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pwd);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录成功");
        }
        preparedStatement.close();
        conn.close();
    }

    /**
     * 演示sql注入
     * @throws Exception
     */
    @Test
    public void TestUserLogin_Inject() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name = "zhangsan1";
        String pwd = "' or '1'='1''";

        // 3. 写执行数据库代码
        String sqlStr = "select * from tb_user where user = '" + name + "' and password = '" + pwd + "';";
        // 4. 获取对象
        Statement stmt = conn.createStatement();
        // 5. 执行语句
        ResultSet rs = stmt.executeQuery(sqlStr);
        // 6. 判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        // 7. 释放资源
        stmt.close();
        conn.close();

        System.out.println(System.getProperty("user.dir"));
    }

}
