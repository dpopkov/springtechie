package com.example.springblog.service;

import com.example.springblog.dto.RegisterRequest;
import com.example.springblog.model.User;
import com.example.springblog.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(RegisterRequest dto) {
        User user = new User();
        user.setUserName(dto.getUsername());
        user.setPassword(encodePassword(dto.getPassword()));
        user.setEmail(dto.getEmail());
        userRepository.save(user);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
