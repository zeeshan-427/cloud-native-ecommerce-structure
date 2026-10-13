package com.ecommerce.payment.controller;

import com.ecommerce.common.dto.ApiResponse;
import com.ecommerce.payment.entity.Payment;
import com.ecommerce.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ApiResponse<Payment> processPayment(
            @RequestBody Payment payment) {

        return new ApiResponse<>(
                true,
                "Payment Processed Successfully",
                paymentService.processPayment(payment)
        );
    }

    @GetMapping
    public ApiResponse<List<Payment>> getAllPayments() {

        return new ApiResponse<>(
                true,
                "Payments Retrieved Successfully",
                paymentService.getAllPayments()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<Payment> getPayment(
            @PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Payment Found",
                paymentService.getPayment(id)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deletePayment(
            @PathVariable Long id) {

        paymentService.deletePayment(id);

        return new ApiResponse<>(
                true,
                "Payment Deleted Successfully",
                null
        );
    }
}