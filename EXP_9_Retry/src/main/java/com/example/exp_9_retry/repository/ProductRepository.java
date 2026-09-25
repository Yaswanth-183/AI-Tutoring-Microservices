package com.example.exp_9_retry.repository;

import com.example.exp_9_retry.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long> {
}