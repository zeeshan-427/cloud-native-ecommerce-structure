package com.ecommerce.inventory.controller;

import com.ecommerce.common.dto.ApiResponse;
import com.ecommerce.inventory.entity.Inventory;
import com.ecommerce.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @PostMapping
    public ApiResponse<Inventory> createInventory(
            @RequestBody Inventory inventory) {

        return new ApiResponse<>(
                true,
                "Inventory Created Successfully",
                service.save(inventory)
        );
    }

    @GetMapping
    public ApiResponse<List<Inventory>> getAllInventory() {

        return new ApiResponse<>(
                true,
                "Inventory Retrieved",
                service.getAllInventory()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<Inventory> getInventory(
            @PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Inventory Found",
                service.getInventory(id)
        );
    }

    @GetMapping("/product/{productId}")
    public ApiResponse<Inventory> getInventoryByProductId(
            @PathVariable("productId") Long productId) {

        return new ApiResponse<>(
                true,
                "Inventory Found",
                service.getByProduct(productId)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteInventory(
            @PathVariable Long id) {

        service.delete(id);

        return new ApiResponse<>(
                true,
                "Inventory Deleted Successfully",
                null
        );
    }
}