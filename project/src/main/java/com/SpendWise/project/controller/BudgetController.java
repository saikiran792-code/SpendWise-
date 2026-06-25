package com.SpendWise.project.controller;

import com.SpendWise.project.model.Budget;
import com.SpendWise.project.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    @Autowired
    BudgetService service;
    @GetMapping("/allbudgets")
    private List<Budget> getbudget(){
        return service.getbudget();
    }
    @PostMapping("/uploadbudget")
    private Budget uploadbudget(@RequestBody Budget budget){
        return service.uploadbudget(budget);
    }
    @PutMapping("/updatebudgetbyid/{budgetid}")
    private Budget updatebudget( @PathVariable int budgetid,
            @RequestBody Budget budget
                               ){
        return service.updatebudget(budgetid,budget);
    }
    @GetMapping("/status/{budgetid}")
    private String getBudgetStatus(@PathVariable int budgetid){
        return service.getBudgetStatus(budgetid);
    }
}
