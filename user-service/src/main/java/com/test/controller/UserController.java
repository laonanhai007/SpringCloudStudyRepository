package com.test.controller;

import com.test.entity.User;
import com.test.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/user/{uid}")
    public User findUserByUid(@PathVariable("uid") int uid) {
        System.out.println("我被调用了");
        return userService.getUserByUid(uid);
    }
}
