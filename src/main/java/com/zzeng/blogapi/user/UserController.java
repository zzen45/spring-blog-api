package com.zzeng.blogapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    // Constructor injection
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // POST /api/users/register
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Save user to the database
        User savedUser = userRepository.save(user);
        // Return the saved user + status 200
        return ResponseEntity.ok(savedUser);
    }
}
