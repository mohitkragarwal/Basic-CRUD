package com.example.crud.Controller;

import com.example.crud.model.User1;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public User1 register(@RequestBody User1 user1)
    {

        return userService.saveUser(user1);

    }

}
