package com.zhh.controller;

import com.zhh.model.User;
import com.zhh.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login() {
        try {
            userService.login(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
