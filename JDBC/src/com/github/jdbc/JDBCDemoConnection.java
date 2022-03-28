package com.github.jdbc;

import java.sql.*;

/**
 * JDBC 的快速入门
 */
public class JDBCDemoConnection {
    public static void main(String[] args) throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 写执行数据库代码
        String sqlStr = "update db1.user set age = 221 where id = 1";
        String sqlStr1 = "update db1.user set age = 322 where id = 2";
        Statement stmt = conn.createStatement();
        try {
            // 开启事物
            conn.setAutoCommit(false);
            // 4. 获取执行sql语句的对象
            // 5. 执行sql
            int count = stmt.executeUpdate(sqlStr);
            // 6. 处理结果
            System.out.println("受影响的行数是:" + count);
            // 5. 执行sql
            int count1 = stmt.executeUpdate(sqlStr1);
            // 6. 处理结果
            System.out.println("受影响的行数是:" + count1);
            // 提交事务
            conn.commit();
        } catch (Exception e) {
            // 回滚
            conn.rollback();
            e.printStackTrace();
        } finally {
            // 7. 释放资源
            assert stmt != null;
            stmt.close();
            conn.close();
        }
    }
}
