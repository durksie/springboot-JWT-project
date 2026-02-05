package com.gift.springboot.JWT.project.config;

import com.gift.springboot.JWT.project.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final UserRepository repository;
     @Autowired
    public ApplicationConfig(UserRepository repository) {
        this.repository = repository;
    }

    //This method represents a bean
    public UserDetailsService userDetailsService() {
        return username -> repository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not Found"));
    }

}