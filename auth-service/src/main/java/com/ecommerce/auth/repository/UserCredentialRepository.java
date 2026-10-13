package com.ecommerce.auth.repository;

import com.ecommerce.auth.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository
        extends JpaRepository<UserCredential, Long> {

    Optional<UserCredential> findByUsername(String username);
}