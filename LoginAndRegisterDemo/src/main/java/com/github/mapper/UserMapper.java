package com.github.mapper;

import com.github.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /**
     * 根据用户名密码查询用户对象
     * @param username 用户的名称
     * @param password 用户的密码
     * @return 返回该用户
     */
    @Select("select * from tb_user where username = #{username} and password = #{password};")
    User select(@Param("username") String username, @Param("password") String password);

    @Select("select * from tb_user where username = #{username};")
    User checkUser(@Param("username")String username);

    @Insert("insert into tb_user (username, password) values (#{username}, #{password});")
    void registerUser(User user);
}
