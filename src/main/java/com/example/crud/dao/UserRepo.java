package com.example.crud.dao;

import com.example.crud.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User1,Integer> {
    User1 findByUsername(String Username);
}
