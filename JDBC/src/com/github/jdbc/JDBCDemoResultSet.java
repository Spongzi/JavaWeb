package com.github.jdbc;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.*;

public class JDBCDemoResultSet {
    @Test
    public void TestDQL() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 写执行数据库代码
        String sqlStr = "select * from user;";
        Statement stmt = conn.createStatement();
        conn.setAutoCommit(false);
        ResultSet resultSet = stmt.executeQuery(sqlStr);
        List<PersonInfo> personInfoList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("id：" + id + "name:" + name + "age:" + age);
            personInfoList.add(new PersonInfo(id, name, age));
        }
        personInfoList.sort(Comparator.comparingInt(PersonInfo::getAge)); // 默认升序
        System.out.println(personInfoList);
        // 7. 释放资源
        stmt.close();
        conn.close();
    }
}

class PersonInfo {
    private int id;
    private String name;
    private int age;


    public PersonInfo() {
    }

    public PersonInfo(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}