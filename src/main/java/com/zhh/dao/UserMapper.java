package com.zhh.dao;

import com.zhh.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yin.zhh
 * 用户相关mapper
 */
@Repository
@Mapper
public interface UserMapper {

    /**
     * 登录
     *
     * @param user 用户
     * @return com.zhh.model.User
     */
    User login(User user);

    /**
     * 用户ID查找
     *
     * @param id 用户id
     * @return com.zhh.model.User
     */
    User getUserById(int id);

    /**
     * 查找所有用户
     *
     * @return List<User>
     */
    List<User> getAllUsers();

    /**
     * 添加用户
     *
     * @param user 用户
     * @return id
     */
    int addUser(User user);

    /**
     * 删除用户
     *
     * @param userName 用户名字
     * @return id
     */
    int deleteUser(String userName);

    /**
     * 删除所有用户
     *
     * @return id
     */
    int deleteAll();

    int updateUserById(/*@Param("user")*/ User usero);
}
