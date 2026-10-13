package com.ecommerce.order.service;

import com.ecommerce.order.client.InventoryClient;
import com.ecommerce.order.client.NotificationClient;
import com.ecommerce.order.client.PaymentClient;
import com.ecommerce.order.client.ProductClient;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final ProductClient productClient;
    private final InventoryClient inventoryClient;
    private final PaymentClient paymentClient;
    private final NotificationClient notificationClient;

    public Order placeOrder(Order order) {

        Object product = productClient.getProduct(order.getProductId());

        System.out.println("PRODUCT RESPONSE = " + product);

        Object inventory = inventoryClient.getInventory(order.getProductId());

        System.out.println("INVENTORY RESPONSE = " + inventory);

        order.setOrderStatus("PLACED");

        Order savedOrder = repository.save(order);

        Map<String, Object> paymentRequest = new HashMap<>();

        paymentRequest.put("orderId", savedOrder.getId());

        paymentRequest.put("amount", savedOrder.getTotalAmount());

        paymentRequest.put("paymentMethod", "UPI");

        Object payment = paymentClient.createPayment(paymentRequest);

        System.out.println("PAYMENT RESPONSE = " + payment);

        Map<String, Object> notificationRequest = new HashMap<>();

        notificationRequest.put("userId", savedOrder.getUserId());

        notificationRequest.put("type", "EMAIL");

        notificationRequest.put("subject", "Order Confirmed");

        notificationRequest.put("message", "Your Order #" + savedOrder.getId() + " has been placed successfully.");

        Object notification = notificationClient.sendNotification(notificationRequest);

        System.out.println("NOTIFICATION RESPONSE = " + notification);

        return savedOrder;
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public List<Order> getOrdersByUser(
            Long userId) {

        return repository.findByUserId(userId);
    }

    public Order getOrder(Long id) {

        return repository.findById(id).orElseThrow(() -> new RuntimeException("Order Not Found"));
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}