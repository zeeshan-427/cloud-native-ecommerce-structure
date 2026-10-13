package com.ecommerce.order.controller;

import com.ecommerce.common.dto.ApiResponse;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ApiResponse<Order> placeOrder(
            @RequestBody Order order) {

        return new ApiResponse<>(
                true,
                "Order Placed Successfully",
                orderService.placeOrder(order)
        );
    }

    @GetMapping
    public ApiResponse<List<Order>> getAllOrders() {

        return new ApiResponse<>(
                true,
                "Orders Retrieved",
                orderService.getAllOrders()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<Order> getOrder(
            @PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Order Found",
                orderService.getOrder(id)
        );
    }

    @GetMapping("/user/{userId}")
    public ApiResponse<List<Order>> getOrdersByUser(
            @PathVariable Long userId) {

        return new ApiResponse<>(
                true,
                "User Orders Retrieved",
                orderService.getOrdersByUser(userId)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteOrder(
            @PathVariable Long id) {

        orderService.deleteOrder(id);

        return new ApiResponse<>(
                true,
                "Order Deleted Successfully",
                null
        );
    }
}