package com.monopoly.gameapi.service;

import com.monopoly.gameapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AuthenticationService {

    @Autowired
    UserService userService;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public User login(String email, String password) {
        List<User> users = userService.getAllUsers(false);
        AtomicReference<User> authenticatedUser = new AtomicReference<>();
        users.forEach(user -> {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                user.setLastLogin(OffsetDateTime.now());
                entityManager.persist(user);
                authenticatedUser.set(user);
            }
        });
        return authenticatedUser.get();
    }
}
