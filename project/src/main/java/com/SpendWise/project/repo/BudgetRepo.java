package com.SpendWise.project.repo;

import com.SpendWise.project.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetRepo extends JpaRepository<Budget,Integer> {
    Optional<Budget> findByUserUserid(long userid);
}
