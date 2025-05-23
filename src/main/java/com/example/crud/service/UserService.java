package com.example.crud.service;

import com.example.crud.dao.UserRepo;
import com.example.crud.model.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);

    public User1 saveUser(User1 user1) {

        user1.setPassword(encoder.encode(user1.getPassword()));
        System.out.println(user1.getPassword());
        return userRepo.save(user1);
    }
}
