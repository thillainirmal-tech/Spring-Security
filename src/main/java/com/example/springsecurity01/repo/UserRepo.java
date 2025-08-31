package com.example.springsecurity01.repo;

import com.example.springsecurity01.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
        Users findByName(String name);
}
