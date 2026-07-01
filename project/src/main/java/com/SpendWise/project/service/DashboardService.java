package com.SpendWise.project.service;

import com.SpendWise.project.dto.DashboardDto;
import com.SpendWise.project.model.Budget;
import com.SpendWise.project.model.Expense;
import com.SpendWise.project.model.User;
import com.SpendWise.project.repo.BudgetRepo;
import com.SpendWise.project.repo.ExpenseRepo;
import com.SpendWise.project.repo.UserRepo;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DashboardService {
    @Autowired
    BudgetRepo budgetRepo;
    @Autowired
    ExpenseRepo expenseRepo;
    @Autowired
    UserRepo userRepo;

    public DashboardDto findbyid(long userid) {
        DashboardDto dto = new DashboardDto();
        User user=userRepo.findById(userid).orElseThrow(null);
        if(user==null){
            return null;
        }
        String username=user.getName();
        List<Expense> expenses = expenseRepo.findByUserUserid(userid);
        long totalExpense = 0;

        for (Expense expense : expenses) {
            totalExpense += expense.getAmount();
        }
        Budget budget = budgetRepo.findByUserUserid(userid)
                .orElseThrow(() -> new RuntimeException("Budget not found"));
        long totalBudget = budget.getAmount();
        long remaining = totalBudget - totalExpense;
        long percentageofspend = ((totalExpense * 100) / totalBudget);
        String status;
        if (percentageofspend >= 100) {
            status = "Budget Exceeded ❌";
        } else if (percentageofspend > 80) {
            status = "Warning ⚠\uFE0E";
        } else {
            status = "Safe ✅";
        }
        dto.setStatus(status);
        dto.setPercentageofspend(percentageofspend);
        dto.setRemaining(remaining);
        dto.setBudgetamount(totalBudget);
        dto.setName(username);
        dto.setTotalexpense(totalExpense);

        return dto;
    }
}
