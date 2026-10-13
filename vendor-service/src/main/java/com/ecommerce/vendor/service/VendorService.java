package com.ecommerce.vendor.service;

import com.ecommerce.vendor.entity.Vendor;
import com.ecommerce.vendor.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository repository;

    public Vendor save(Vendor vendor) {
        return repository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return repository.findAll();
    }

    public Vendor getVendor(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Vendor Not Found"));
    }

    public void deleteVendor(Long id) {
        repository.deleteById(id);
    }
}