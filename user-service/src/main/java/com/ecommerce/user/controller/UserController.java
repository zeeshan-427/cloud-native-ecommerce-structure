package com.ecommerce.user.controller;

import com.ecommerce.common.dto.ApiResponse;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ApiResponse<User> createUser(
            @RequestBody User user) {

        return new ApiResponse<>(
                true,
                "User Created Successfully",
                service.save(user)
        );
    }

    @GetMapping
    public ApiResponse<List<User>> getAllUsers() {

        return new ApiResponse<>(
                true,
                "Users Retrieved",
                service.getAllUsers()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getUser(
            @PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "User Found",
                service.getUser(id)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(
            @PathVariable Long id) {

        service.deleteUser(id);

        return new ApiResponse<>(
                true,
                "User Deleted",
                null
        );
    }
}