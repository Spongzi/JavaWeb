package com.github.mapper;

import com.github.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
