package com.example.exp_4_saga.service;

import com.example.exp_4_saga.entity.Product;
import com.example.exp_4_saga.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    private final ProductRepository productRepository;

    public InventoryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public boolean reserveStock(
            Long productId,
            int quantity) {

        Product product =
                productRepository.findById(productId)
                        .orElseThrow();

        System.out.println(
                "Available stock: "
                        + product.getStock()
        );

        System.out.println(
                "Requested quantity: "
                        + quantity
        );

        if (product.getStock() < quantity) {

            System.out.println(
                    "Inventory reservation failed"
            );

            return false;
        }

        product.setStock(
                product.getStock() - quantity
        );

        productRepository.save(product);

        System.out.println(
                "Inventory reserved successfully"
        );

        return true;
    }

    @Transactional
    public void restoreStock(
            Long productId,
            int quantity) {

        Product product =
                productRepository.findById(productId)
                        .orElseThrow();

        product.setStock(
                product.getStock() + quantity
        );

        productRepository.save(product);

        System.out.println(
                "Stock restored: " + quantity
        );
    }
}