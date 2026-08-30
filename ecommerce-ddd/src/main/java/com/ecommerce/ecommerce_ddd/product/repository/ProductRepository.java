package com.ecommerce.ecommerce_ddd.product.repository;

import com.ecommerce.ecommerce_ddd.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}