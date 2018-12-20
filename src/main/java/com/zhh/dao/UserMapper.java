package com.zhh.dao;

import com.zhh.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserMapper {

    User login(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(String userName);

    void deleteAll();
}
