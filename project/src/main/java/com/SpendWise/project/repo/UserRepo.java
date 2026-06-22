package com.SpendWise.project.repo;

import com.SpendWise.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User , Long> {
}
