package com.ecommerce.inventory.service;

import com.ecommerce.inventory.entity.Inventory;
import com.ecommerce.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository repository;

    public Inventory save(Inventory inventory) {
        return repository.save(inventory);
    }

    public List<Inventory> getAllInventory() {
        return repository.findAll();
    }

    public Inventory getInventory(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Inventory Not Found"));
    }

    public Inventory getByProduct(Long productId) {
        return repository.findByProductId(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product Inventory Not Found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}