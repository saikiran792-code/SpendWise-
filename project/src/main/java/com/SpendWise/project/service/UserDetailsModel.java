package com.SpendWise.project.service;

import com.SpendWise.project.model.User;
import com.SpendWise.project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsModel implements UserDetailsService {
    @Autowired
    UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=repo.findByEmail(email);
        if(user==null){
            throw  new UsernameNotFoundException("Email is not found");}
        return new UserPrincipal(user);
    }
}
