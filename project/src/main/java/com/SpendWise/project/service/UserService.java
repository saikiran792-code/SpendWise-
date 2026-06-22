package com.SpendWise.project.service;

import com.SpendWise.project.model.User;
import com.SpendWise.project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo repo;
    public User register(User user){
        return repo.save(user);

    }
}
