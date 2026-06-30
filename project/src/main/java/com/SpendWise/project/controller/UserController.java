package com.SpendWise.project.controller;

import com.SpendWise.project.model.Budget;
import com.SpendWise.project.model.Expense;
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
    private User register(@RequestBody User user) {
        System.out.println("User is registed");
        return service.register(user);
    }

    @PostMapping("/login")
    private String login(@RequestBody User user) {
        System.out.println("Login succed");
        return service.login(user);
    }

    @PostMapping("/{userid}/expenses")
    public Expense addExpense(
            @PathVariable long userid,
            @RequestBody Expense expense) {

        return service.addExpense(userid, expense);
    }

    @PostMapping("/{userid}/Budget")
    public Budget addBudget(
            @PathVariable long userid,
            @RequestBody Budget budget){
        return service.addBudget(userid,budget);
    }

}
