package com.monopoly.gameapi.controller;

import com.monopoly.gameapi.model.User;
import com.monopoly.gameapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public @ResponseBody List<User> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return users;
    }

    @PostMapping("/user")
    public User creatUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }
}
