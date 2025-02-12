package com.jeyavel.janitri_backend.service;

import com.jeyavel.janitri_backend.model.User;
import com.jeyavel.janitri_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.filter(u -> u.getPassword().equals(password));
    }
}