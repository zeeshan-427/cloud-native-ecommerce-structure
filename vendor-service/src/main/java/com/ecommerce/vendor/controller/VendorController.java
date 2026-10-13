package com.ecommerce.vendor.controller;

import com.ecommerce.common.dto.ApiResponse;
import com.ecommerce.vendor.entity.Vendor;
import com.ecommerce.vendor.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService service;

    @PostMapping
    public ApiResponse<Vendor> createVendor(
            @RequestBody Vendor vendor) {

        return new ApiResponse<>(
                true,
                "Vendor Created Successfully",
                service.save(vendor)
        );
    }

    @GetMapping
    public ApiResponse<List<Vendor>> getAllVendors() {

        return new ApiResponse<>(
                true,
                "Vendors Retrieved",
                service.getAllVendors()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<Vendor> getVendor(
            @PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Vendor Found",
                service.getVendor(id)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteVendor(
            @PathVariable Long id) {

        service.deleteVendor(id);

        return new ApiResponse<>(
                true,
                "Vendor Deleted",
                null
        );
    }
}