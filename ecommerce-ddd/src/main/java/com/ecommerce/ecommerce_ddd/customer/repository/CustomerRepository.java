package com.ecommerce.ecommerce_ddd.customer.repository;

import com.ecommerce.ecommerce_ddd.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}