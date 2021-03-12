package com.example.springblog.service;

import com.example.springblog.dto.RegisterRequest;
import com.example.springblog.model.User;
import com.example.springblog.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signup(RegisterRequest dto) {
        User user = new User();
        user.setUserName(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        userRepository.save(user);
    }
}
