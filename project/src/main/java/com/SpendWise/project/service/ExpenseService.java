package com.SpendWise.project.service;

import com.SpendWise.project.model.Expense;
import com.SpendWise.project.repo.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepo repo;

    public Expense addExpense(Expense expense) {
        return repo.save(expense);
    }

    public String deleteExpense(int eid) {
        if(repo.existsById(eid)) {
            repo.deleteById(eid);
            return "expense deleted";
        }
        return " it is not found";
    }

    public List<Expense> getexpenses() {
        return repo.findAll();
    }

    public Optional<Expense> getbyid(int eid) {
        return Optional.of(repo.findById(eid).get());
    }

    public Expense updateExpense(int eid,Expense expense) {
        if(repo.existsById(eid)) {
            expense.setEid(eid);
            return repo.save(expense);
        }

        return null;
    }
    public List<Expense> getExpensesByUser(long userid) {
        return repo.findByUserUserid( userid);
    }
}
