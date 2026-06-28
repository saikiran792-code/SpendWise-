package com.SpendWise.project.service;

import com.SpendWise.project.dto.BudgetStatusDTO;
import com.SpendWise.project.model.Budget;
import com.SpendWise.project.model.Expense;
import com.SpendWise.project.repo.BudgetRepo;
import com.SpendWise.project.repo.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {
    @Autowired
    BudgetRepo repo;
    @Autowired
    ExpenseRepo erepo;


    public List<Budget> getbudget() {
        return repo.findAll();
    }


    public Budget uploadbudget(Budget budget) {
        return repo.save(budget);
    }

    public Budget updatebudget(int budgetid, Budget budget) {


        if (repo.existsById(budgetid)) {
            budget.setBudgetid(budgetid);
            return repo.save(budget);
        }
        return null;
    }

    public BudgetStatusDTO getBudgetStatus(int budgetid) {
        BudgetStatusDTO dto=new BudgetStatusDTO();
        Budget budget = repo.findById(budgetid)
                .orElse( null);
        if (budget == null) {
            return null;
        }
        long totalexpense = 0;
        List<Expense> expenses = erepo.findAll();
        for (Expense expense : expenses) {
            totalexpense += expense.getAmount();
        }
        long budgetamount = budget.getAmount();
        long remaining = budgetamount - totalexpense;
        long percentageofspend = ((totalexpense * 100) / budgetamount);
        long exceeded = totalexpense - budgetamount;
        System.out.println("Budget Amount = " + budgetamount);
        System.out.println("Total Expense = " + totalexpense);
        String status;

        if (percentageofspend >= 100) {
            status = "Budget Exceeded ❌";
        } else if (percentageofspend > 80) {
            status = "Warning ⚠\uFE0F";
        } else {
            status = "Safe ✅";
        }

        dto.setBudgetamount(budgetamount);
        dto.setTotalexpense(totalexpense);
        dto.setRemaining(remaining);
        dto.setPercentageofspend(percentageofspend);
        dto.setStatus(status);
        return dto;

    }
}
