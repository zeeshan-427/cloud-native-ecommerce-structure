package com.ecommerce.vendor.repository;

import com.ecommerce.vendor.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository
        extends JpaRepository<Vendor, Long> {
}