package com.example.crud.Controller;

import com.example.crud.model.User1;
import com.example.crud.service.JwtService;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public User1 register(@RequestBody User1 user1)
    {

        return userService.saveUser(user1);
    }

    @PostMapping("/login")
    public String login(@RequestBody User1 user1)
    {
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user1.getUsername(),user1.getPassword()) );
        if(authentication.isAuthenticated())
            return jwtService.getToken(user1.getUsername());
        else return "failure";
    }

}
