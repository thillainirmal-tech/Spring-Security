package com.example.springsecurity01.controller;

import com.example.springsecurity01.model.Users;
import com.example.springsecurity01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        Users newuser = userService.saveUser(user);
        return newuser;
    }
}
