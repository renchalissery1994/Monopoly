package com.monopoly.gameapi.controller;

import com.monopoly.gameapi.model.User;
import com.monopoly.gameapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<User>();
        User user = new User();
        user.setFirstName("Ren");
        user.setLastName("Chalissery");
        user.setPassword("pass");
        users.add(user);
        return users;
    }

    @PostMapping("/user")
    public User creatUser(@RequestBody User user){
        return userService.createUser(user);
    }
}