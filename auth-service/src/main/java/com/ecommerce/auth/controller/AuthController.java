package com.ecommerce.auth.controller;

import com.ecommerce.auth.entity.UserCredential;
import com.ecommerce.auth.service.AuthService;
import com.ecommerce.common.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<UserCredential> register(
            @RequestBody UserCredential userCredential) {
        System.out.println("REGISTER API HIT");



        UserCredential savedUser =
                authService.register(userCredential);

        return new ApiResponse<>(
                true,
                "User Registered Successfully",
                savedUser
        );
    }

    @PostMapping("/login")
    public ApiResponse<String> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        String result =
                authService.login(username, password);

        return new ApiResponse<>(
                true,
                "Login Successful",
                result
        );
    }
}