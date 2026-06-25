package com.SpendWise.project.repo;

import com.SpendWise.project.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepo extends JpaRepository<Budget,Integer> {
}
