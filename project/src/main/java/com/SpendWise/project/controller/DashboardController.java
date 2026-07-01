package com.SpendWise.project.controller;

import com.SpendWise.project.dto.DashboardDto;
import com.SpendWise.project.model.User;
import com.SpendWise.project.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/Dashboard")
public class DashboardController {
    @Autowired
    DashboardService service;

    @GetMapping("/{userid}")
    private DashboardDto findbyid(@PathVariable long userid){
        return service.findbyid(userid);
    }

}
