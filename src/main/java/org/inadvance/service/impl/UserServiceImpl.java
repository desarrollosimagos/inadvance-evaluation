package org.inadvance.service.impl;

import org.inadvance.dto.UserDTO;
import org.inadvance.model.User;
import org.inadvance.repository.UserRepository;
import org.inadvance.service.UserService;
import org.inadvance.service.mapper.UserMapper;
import org.inadvance.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;
import java.util.regex.Pattern;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private Environment env;

    @Override
    public UserDTO registerUser(User newUser) {
        validateEmail(newUser.getEmail());
        validatePassword(newUser.getPassword());
        validateAlreadyEmail(newUser);
        newUser.setToken(jwtUtil.generateToken(newUser));
        newUser.setActive(Boolean.TRUE);
        return UserMapper.INSTANCE.userToUserDTO(userRepository.save(newUser));
    }

    @Override
    public List<UserDTO> getListUser(){
        return UserMapper.INSTANCE.usersToUserDTOs(userRepository.findAll());
    }

    private void validateAlreadyEmail(User newUser){
        if (userRepository.existsByEmail(newUser.getEmail())) {
            throw new IllegalArgumentException("Email already registered.");
        }
    }

    private void validateEmail(String email) {
        String regex = env.getProperty("user.email.regex");
        if (!Pattern.matches(regex, email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    private void validatePassword(String password) {
        String regex = env.getProperty("user.password.regex");
        if (!Pattern.matches(regex, password)) {
            throw new IllegalArgumentException("Invalid password format");
        }
    }
}