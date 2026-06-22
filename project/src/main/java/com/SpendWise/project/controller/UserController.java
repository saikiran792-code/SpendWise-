package com.SpendWise.project.controller;

import com.SpendWise.project.model.User;
import com.SpendWise.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userapi")
public class UserController {
    @Autowired
    UserService service;
    @PostMapping("/register")
    private User register(@RequestBody User user){
        System.out.println("User is registed");
        return service.register(user);
    }
}
