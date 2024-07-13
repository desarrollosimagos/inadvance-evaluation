package org.inadvance.controller;

import org.inadvance.dto.UserDTO;
import org.inadvance.model.User;
import org.inadvance.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            UserDTO createdUser = userService.registerUser(user);
            return ResponseEntity.ok(createdUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> getListUser(){
        List<UserDTO> users = userService.getListUser();
        return ResponseEntity.ok(users);
    }

}
