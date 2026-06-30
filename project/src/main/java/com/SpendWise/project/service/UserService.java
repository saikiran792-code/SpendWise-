package com.SpendWise.project.service;

import com.SpendWise.project.model.Budget;
import com.SpendWise.project.model.Expense;
import com.SpendWise.project.model.User;
import com.SpendWise.project.repo.BudgetRepo;
import com.SpendWise.project.repo.ExpenseRepo;
import com.SpendWise.project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo repo;
    @Autowired
    ExpenseRepo erepo;
    @Autowired
    BudgetRepo brepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder(12);

    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }


    public String login(User user) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.getEmail(),
                                user.getPassword()
                        )
                );

        if (authentication.isAuthenticated()) {
            return "Login Successful";
        }

        return "Login Failed";
    }

    public Expense addExpense(long userid, Expense expense) {
        User user = repo.findById(userid)
                .orElseThrow(() -> new RuntimeException("User not found"));
        expense.setUser(user);
        return erepo.save(expense);
    }

    public Budget addBudget(long userid, Budget budget) {
        User user=repo.findById(userid)
                .orElseThrow(()->new RuntimeException("User not found"));
        budget.setUser(user);
        return brepo.save(budget);
    }
}
