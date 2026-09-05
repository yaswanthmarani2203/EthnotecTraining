package org.example.sms109.controller;

import org.example.sms109.entity.UserEntity;
import org.example.sms109.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService ser;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserEntity user)
    {
        return ser.userRegister(user);
    }

    @PostMapping("/login")
    public UserEntity login(@RequestBody UserEntity user) {
        return ser.login(user);
    }
}
