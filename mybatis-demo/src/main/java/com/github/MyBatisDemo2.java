package com.github;

import com.github.mapper.UserMapper;
import com.github.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis 代理开发
 */
public class MyBatisDemo2 {
    public static void main(String[] args) throws IOException {
        // 1. 加载mybatis的核心配置文件， 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象用来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 执行sql
//        List<User> users = sqlSession.selectList("test.selectAll");
        // 3. UserMapper 对应的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);

        // 4. 释放资源
        sqlSession.close();
    }
}
