package com.ecommerce.cart.service;

import com.ecommerce.cart.entity.Cart;
import com.ecommerce.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository repository;

    public Cart addToCart(Cart cart) {
        return repository.save(cart);
    }

    public List<Cart> getAllItems() {
        return repository.findAll();
    }

    public List<Cart> getUserCart(Long userId) {
        return repository.findByUserId(userId);
    }

    public void removeItem(Long id) {
        repository.deleteById(id);
    }
}