package com.zhh;

import com.zhh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAngularApplicationTests {

    @Autowired
    private UserService userService;


    @Test
    public void contextLoads() {
        try {
            userService.login(null);
            userService.login(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

