package com.ecommerce.notification.service;

import com.ecommerce.notification.entity.Notification;
import com.ecommerce.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;

    public Notification create(Notification notification) {
        notification.setStatus("SENT");
        return repository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    public Notification getNotification(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Notification Not Found"));
    }

    public void deleteNotification(Long id) {
        repository.deleteById(id);
    }
}