package com.ecommerce.notification.controller;

import com.ecommerce.common.dto.ApiResponse;
import com.ecommerce.notification.entity.Notification;
import com.ecommerce.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public ApiResponse<Notification> sendNotification(
            @RequestBody Notification notification) {

        return new ApiResponse<>(
                true,
                "Notification Sent Successfully",
                notificationService.create(notification)
        );
    }

    @GetMapping
    public ApiResponse<List<Notification>> getAllNotifications() {

        return new ApiResponse<>(
                true,
                "Notifications Retrieved Successfully",
                notificationService.getAllNotifications()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<Notification> getNotification(
            @PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Notification Found",
                notificationService.getNotification(id)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteNotification(
            @PathVariable Long id) {

        notificationService.deleteNotification(id);

        return new ApiResponse<>(
                true,
                "Notification Deleted Successfully",
                null
        );
    }
}