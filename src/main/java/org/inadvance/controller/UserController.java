package org.inadvance.controller;

import org.inadvance.dto.UserRequestDTO;
import org.inadvance.dto.UserResponseDTO;
import org.inadvance.model.User;
import org.inadvance.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequestDTO user) {
        Map<String, String> errors = new HashMap<>();
        try {
            UserResponseDTO createdUser = userService.registerUser(user);
            return ResponseEntity.ok(createdUser);
        } catch (IllegalArgumentException e) {
            errors.put("message",e.getMessage());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getListUser(){
        try {
            List<UserResponseDTO> users = userService.getListUser();
            return ResponseEntity.ok(users);
        } catch (IllegalArgumentException e) {
            Map<String, String> errors = new HashMap<>();
            errors.put("message",e.getMessage());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
    }

}
