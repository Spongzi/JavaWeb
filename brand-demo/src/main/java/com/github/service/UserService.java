package com.github.service;

import com.github.mapper.UserMapper;
import com.github.pojo.User;
import com.github.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     */
    public User login(String username, String password) {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取mapper对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.select(username, password);
        sqlSession.close();
        return user;
    }

    /**
     * 用户注册
     */
    public boolean register(User user) {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取mapper对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 查询用户是否存在
        User u = userMapper.checkUser(user.getUsername());
        if (u == null) {
            userMapper.registerUser(user);
            sqlSession.commit();
        }
        sqlSession.close();

        return u == null;
    }
}
