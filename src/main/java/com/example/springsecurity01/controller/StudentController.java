package com.example.springsecurity01.controller;

import com.example.springsecurity01.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {


    List<Student> students=new ArrayList<>(List.of(
            new Student(1,"Navin","navi@yopmail.com","Java"),
            new Student(2,"Kiran","kiran@yopmail.com","Blockchain")
    ));

    @GetMapping("/csrf")
    public CsrfToken csrf(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }
    @PostMapping("/students")
    public void setStudents(@RequestBody Student student) {

        students.add(student);
    }

}
