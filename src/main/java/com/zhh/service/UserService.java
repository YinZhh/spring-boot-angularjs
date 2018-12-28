package com.zhh.service;

import com.zhh.model.User;

public interface UserService {
    User login(User user) throws Exception;


    User updateUserById(User user) throws Exception;
}
