package com.todo.rest.controller;

import com.todo.rest.entity.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

    @GetMapping("/basic-auth")
    public AuthenticationBean login(){
        return new AuthenticationBean("You are authenticated");
    }
}
