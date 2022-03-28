package com.github.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC 的快速入门
 */
public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 写执行数据库代码
        String sqlStr = "update db1.user set age = 20 where id = 1";
        // 4. 获取执行sql语句的对象
        Statement stmt = conn.prepareStatement(sqlStr);
        // 5. 执行sql
        int count = stmt.executeUpdate(sqlStr);
        // 6. 处理结果
        System.out.println("受影响的行数是:" + count);
        // 7. 释放资源
        stmt.close();
        conn.close();
    }
}
