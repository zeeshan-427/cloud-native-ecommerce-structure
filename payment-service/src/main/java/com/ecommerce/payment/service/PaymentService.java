package com.ecommerce.payment.service;

import com.ecommerce.payment.entity.Payment;
import com.ecommerce.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;

    public Payment processPayment(Payment payment) {

        payment.setPaymentStatus("SUCCESS");

        return repository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    public Payment getPayment(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Payment Not Found"));
    }

    public void deletePayment(Long id) {
        repository.deleteById(id);
    }
}