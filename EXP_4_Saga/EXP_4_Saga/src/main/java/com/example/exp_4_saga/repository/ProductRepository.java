package com.example.exp_4_saga.repository;

import com.example.exp_4_saga.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

}