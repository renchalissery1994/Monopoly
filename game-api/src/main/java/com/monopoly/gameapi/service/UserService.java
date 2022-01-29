package com.monopoly.gameapi.service;

import com.monopoly.gameapi.model.User;
import com.monopoly.gameapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public String deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        String status = null;
        if (user.isPresent()) {
            userRepository.delete(user.get());
            status = "Success";
        } else {
            status = "Failed";
        }
        return status;
    }
}
