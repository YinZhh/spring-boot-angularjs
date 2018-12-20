package com.zhh.service.impl;

import com.zhh.dao.UserMapper;
import com.zhh.model.User;
import com.zhh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public User login(User user) throws Exception {
        User userById = userMapper.getUserById(27);
        logger.info(userById.toString());
        return userById;
    }
}
