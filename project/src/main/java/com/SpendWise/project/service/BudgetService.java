package com.SpendWise.project.service;

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

    public String getBudgetStatus(int budgetid) {
        Budget budget = repo.findById(budgetid)
                .orElse(null);
        if (budget == null) {
            return "Budget not found";
        }
        long totalexpense = 0;
        List<Expense> expenses = erepo.findAll();
        for (Expense expense : expenses) {
            totalexpense += expense.getAmmount();
        }
        long budgetammount = budget.getAmmount();
        long remaining = budget.getAmmount() - totalexpense;
        long percentageofspend = ((totalexpense * 100) / budgetammount);
        String status;

        if (percentageofspend >= 100) {
            status = "Budget Exceeded ❌";
        } else if (percentageofspend > 80) {
            status = "Warning ⚠\uFE0F";
        } else {
            status = "Safe ✅";
        }

        return "Budget " + budgetammount +
                " \nSpent " + totalexpense +
                "\n Remaining " + remaining +
                " \nPercentage " + percentageofspend + "%" +
                " \nStatus " +" version 1"+ status;

    }
}
