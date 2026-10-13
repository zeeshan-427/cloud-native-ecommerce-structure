package com.ecommerce.auth.service;

import com.ecommerce.auth.entity.UserCredential;
import com.ecommerce.auth.repository.UserCredentialRepository;
import com.ecommerce.auth.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserCredentialRepository repository;
    private final JwtUtil jwtUtil;

    public UserCredential register(UserCredential user) {

        System.out.println("REGISTER USER = " + user.getUsername());

        return repository.save(user);
    }

    public String login(String username, String password) {

        UserCredential user =
                repository.findByUsername(username)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User Not Found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException(
                    "Invalid Credentials");
        }

        return jwtUtil.generateToken(username);
    }
}