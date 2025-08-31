package com.example.springsecurity01.service;

import com.example.springsecurity01.model.UserImplement;
import com.example.springsecurity01.model.Users;
import com.example.springsecurity01.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
      Users user=  userRepo.findByName(name);
      if (user == null) {
          throw new UsernameNotFoundException(name);
      }
        return new UserImplement(user);
    }
}
