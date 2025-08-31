package com.example.springsecurity01.service;

import com.example.springsecurity01.model.Users;
import com.example.springsecurity01.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

    public Users saveUser(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);

    }
}
