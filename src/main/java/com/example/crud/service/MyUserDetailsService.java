package com.example.crud.service;

import com.example.crud.dao.UserRepo;
import com.example.crud.model.User1;
import com.example.crud.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User1 user1=repo.findByUsername(username);
        if(user1 == null){
            System.out.println("User 404");
            throw new UsernameNotFoundException("user 404");
        }
        return new UserPrincipal(user1);
    }
}
