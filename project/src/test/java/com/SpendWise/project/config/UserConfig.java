package com.SpendWise.project.config;

import com.SpendWise.project.service.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class UserConfig {
    @Autowired
    private UserPrincipal userPrincipal;

}
