package com.monopoly.gameapi.service;

import com.monopoly.gameapi.model.User;
import com.monopoly.gameapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public User createUser(User user) {
        user.setRegisteredOn(OffsetDateTime.now());
        return userRepository.save(user);
    }

    @Transactional
    public User getUser(Long id) {
        User user = userRepository.findById(id).get();
        entityManager.detach(user);
        user.setPassword(null);
        return user;
    }

    @Transactional
    public List<User> getAllUsers(boolean removePassword) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getDeletedOn() == null)
                .map(user -> {
                    if (removePassword) {
                        entityManager.detach(user);
                        user.setPassword(null);
                    }
                    return user;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public String deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        String status = null;
        if (user.isPresent()) {
            user.get().setDeletedOn(OffsetDateTime.now());
            status = "Success";
        } else {
            status = "Failed";
        }
        return status;
    }
}
