package com.jeyavel.janitri_backend.controller;

import com.jeyavel.janitri_backend.model.User;
import com.jeyavel.janitri_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        Optional<User> loggedInUser = userService.loginUser(user.getEmail(), user.getPassword());
        return loggedInUser.isPresent() ?
                ResponseEntity.ok("Login successful") :
                ResponseEntity.status(401).body("Invalid credentials");
    }
}


