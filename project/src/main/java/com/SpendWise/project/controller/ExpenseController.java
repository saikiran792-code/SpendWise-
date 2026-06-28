package com.SpendWise.project.controller;

import com.SpendWise.project.model.Expense;
import com.SpendWise.project.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    ExpenseService service;

    @PostMapping("/addEx")
    private Expense addexpense(@RequestBody Expense expense){
        return service.addExpense(expense);
    }

    @DeleteMapping("/delete/{eid}")
    private String deleteExpense(@PathVariable int eid){
       return service.deleteExpense(eid);
    }
    @GetMapping("/allexpenses")
    private List<Expense> getexpenses(){
        return service.getexpenses();
    }
    @GetMapping("getbyid/{eid}")
    private Optional<Expense> getbyid(@PathVariable int eid){
        return service.getbyid(eid);
    }
    @PutMapping("/update/{eid}")
    private Expense updateExpense(@PathVariable int eid,
            @RequestBody Expense expense ){
        return service.updateExpense(eid,expense);
    }

}
