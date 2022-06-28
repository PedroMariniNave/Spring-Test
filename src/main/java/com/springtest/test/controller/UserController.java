package com.springtest.test.controller;

import com.springtest.test.model.UserModel;
import com.springtest.test.reposity.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/api/all-users")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping(path = "/api/users/{user_id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("user_id") int userId) {
        return userRepository.findById(userId).map(ResponseEntity::ok).orElse(null);
    }

    @PostMapping(path = "/api/save-user")
    public UserModel saveUserData(@RequestBody UserModel user) {
        return userRepository.save(user);
    }
}