package com.github.jdbc;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC 的快速入门
 */
public class JDBCDemoStatement {
    /**
     * 执行DML语句
     */
    @Test
    public void TestDML() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 写执行数据库代码
        String sqlStr = "update db1.user set age = 21 where id = 1";
        Statement stmt = conn.createStatement();
        conn.setAutoCommit(false);
        int count = stmt.executeUpdate(sqlStr);
        System.out.println("受影响的行数是:" + count);
        // 7. 释放资源
        stmt.close();
        conn.close();
    }

    /**
     * 执行DDL语句
     */
    @Test
    public void TestDDL() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 写执行数据库代码
        String sqlStr = "drop database db2";
        Statement stmt = conn.createStatement();
        conn.setAutoCommit(false);
        int count = stmt.executeUpdate(sqlStr);
        System.out.println("受影响的行数是:" + count);
        // 7. 释放资源
        stmt.close();
        conn.close();
    }
}
