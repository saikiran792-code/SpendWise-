package com.SpendWise.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthapi")
public class healthController {
    @GetMapping()
    public String healthDetails(){
        return "it is working";
    }

}
