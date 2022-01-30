package com.monopoly.gameapi.controller;

import com.monopoly.gameapi.model.User;
import com.monopoly.gameapi.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;


    @GetMapping("/login")
    public @ResponseBody
    User getUser(@RequestParam String email, @RequestParam String password) {
        return authenticationService.login(email, password);
    }
}
