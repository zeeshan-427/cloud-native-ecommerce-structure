package com.ecommerce.cart.controller;

import com.ecommerce.cart.entity.Cart;
import com.ecommerce.cart.service.CartService;
import com.ecommerce.common.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ApiResponse<Cart> addToCart(
            @RequestBody Cart cart) {

        return new ApiResponse<>(
                true,
                "Item Added To Cart",
                cartService.addToCart(cart)
        );
    }

    @GetMapping
    public ApiResponse<List<Cart>> getAllItems() {

        return new ApiResponse<>(
                true,
                "Cart Items Retrieved",
                cartService.getAllItems()
        );
    }

    @GetMapping("/user/{userId}")
    public ApiResponse<List<Cart>> getUserCart(
            @PathVariable Long userId) {

        return new ApiResponse<>(
                true,
                "User Cart Retrieved",
                cartService.getUserCart(userId)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> removeItem(
            @PathVariable Long id) {

        cartService.removeItem(id);

        return new ApiResponse<>(
                true,
                "Item Removed From Cart",
                null
        );
    }
}