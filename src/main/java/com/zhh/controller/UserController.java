package com.zhh.controller;

import com.zhh.model.User;
import com.zhh.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    private int count = 1;

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

    @RequestMapping("/updateUser")
    public String updateUser() {
        try {
            User u = new User();
            u.setUserId(27);
            u.setPassword(String.valueOf(count++));

            User user = userService.updateUserById(u);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/luckydraw/luckydraw";
    }

    @RequestMapping("/luckydraw")
    public String luckydraw() {
        return "/luckydraw/luckydraw";
    }
}
