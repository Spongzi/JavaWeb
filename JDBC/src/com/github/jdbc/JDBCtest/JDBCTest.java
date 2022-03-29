package com.github.jdbc.JDBCtest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 实现数据库的增删改查，使用代码
 */
public class JDBCTest {
    // 创建一个List用来存储查询到的数据
    public static List<Brand> brands = new ArrayList<>();

    // 1. 连接数据库
    // url的书写--> jdbc:mysql://数据库地址/数据库名称
    public static String sql_url = "jdbc:mysql://127.0.0.1:3306/db1";
    public static String sql_name = "root";
    public static String sql_pwd = "123456";
    public static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection(sql_url, sql_name, sql_pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        // 调用查询数据
        SelectSql();
        System.out.println(brands);
        DeleteById();
        SelectSql();
        System.out.println(brands);
    }

    /**
     * 查询所有数据
     */
    public static void SelectSql() throws Exception {
        // 清空brands后查询
        brands.clear();

        // 2. 书写查询的语句
        String sqlStr = "select * from tb_brand;";

        // 3. 创建prepareStatement
        PreparedStatement stat = conn.prepareStatement(sqlStr);

        // 4. 得到ResultSet
        ResultSet rs = stat.executeQuery();

        // 5. 遍历
        while (rs.next()) {
            int id = rs.getInt("id");
            String brand_name = rs.getString("brand_name");
            String company_name = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");
            brands.add(new Brand(id, brand_name, company_name, ordered, description, status));
        }
    }

    /**
     * 添加数据
     */
    public static void addBrand() throws Exception {
        // 2. 书写查询的语句
        String sqlStr = "insert into tb_brand (brand_name, company_name, ordered, description, status) values (?, ?, ?, ?, ?);";

        // 3. 创建prepareStatement
        PreparedStatement stat = conn.prepareStatement(sqlStr);

        // 4. 输入你要添加的信息
        System.out.print("请输入你要添加的商品名称：");
        String brand_name = scanner.nextLine();
        System.out.print("请输入你要添加的公司名称：");
        String company_name = scanner.nextLine();
        System.out.print("请输入排序字段：");
        int ordered = Integer.parseInt(scanner.nextLine());
        System.out.print("请输入描述信息：");
        String description = scanner.nextLine();
        System.out.print("请输入该商品状态码(0：禁用  1：启用)：");
        int status = Integer.parseInt(scanner.nextLine());

        // 5. 给sql语句赋值
        stat.setString(1, brand_name);
        stat.setString(2, company_name);
        stat.setInt(3, ordered);
        stat.setString(4, description);
        stat.setInt(5, status);

        // 6. 执行代码
        stat.executeUpdate();
    }

    /**
     * 根据Id修改信息
     */
    public static void ModifyById() throws Exception {
        // 2. 书写查询的语句
        String sqlStr = "update tb_brand set brand_name = ?, company_name = ?, ordered = ?, description = ?, status = ? " +
                " where id = ? ;";

        // 3. 创建prepareStatement
        PreparedStatement stat = conn.prepareStatement(sqlStr);

        System.out.println("请输入你要修改的id");
        int id = Integer.parseInt(scanner.nextLine());

        // 4. 输入你要修改的信息
        System.out.print("请输入你要修改的商品名称：");
        String brand_name = scanner.nextLine();
        System.out.print("请输入你要修改的公司名称：");
        String company_name = scanner.nextLine();
        System.out.print("请输入排序字段：");
        int ordered = Integer.parseInt(scanner.nextLine());
        System.out.print("请输入描述信息：");
        String description = scanner.nextLine();
        System.out.print("请输入该商品状态码(0：禁用  1：启用)：");
        int status = Integer.parseInt(scanner.nextLine());

        stat.setString(1, brand_name);
        stat.setString(2, company_name);
        stat.setInt(3, ordered);
        stat.setString(4, description);
        stat.setInt(5, status);
        stat.setInt(6, id);

        stat.executeUpdate();
    }

    /**
     * 根据Id删除信息
     */
    public static void DeleteById() throws SQLException {
        // 2. 书写查询的语句
        String sqlStr = "delete from tb_brand where id = ?;";

        // 3. 创建prepareStatement
        PreparedStatement stat = conn.prepareStatement(sqlStr);

        // 4. 请输入你要删除商品的id
        int id = Integer.parseInt(scanner.nextLine());

        // 5. 设置变量
        stat.setInt(1, id);

        // 6. 执行代码
        stat.executeUpdate();
    }
}
