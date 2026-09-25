package com.example.exp_9_retry.service;

import com.example.exp_9_retry.entity.Product;
import com.example.exp_9_retry.entity.Reservation;
import com.example.exp_9_retry.exception.TransientInventoryException;
import com.example.exp_9_retry.repository.ProductRepository;
import com.example.exp_9_retry.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class InventoryService {

    private final ProductRepository productRepository;
    private final ReservationRepository reservationRepository;

    public InventoryService(
            ProductRepository productRepository,
            ReservationRepository reservationRepository) {

        this.productRepository = productRepository;
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public Reservation reserve(
            String requestId,
            Long productId,
            int quantity) {

        Reservation existing =
                reservationRepository
                        .findByRequestId(requestId)
                        .orElse(null);

        if (existing != null) {

            System.out.println(
                    "Duplicate request detected: "
                            + requestId
            );

            return existing;
        }

        Product product =
                productRepository.findById(productId)
                        .orElseThrow(
                                () -> new IllegalArgumentException(
                                        "Product not found"
                                )
                        );

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero"
            );
        }

        if (product.getStock() < quantity) {
            throw new IllegalArgumentException(
                    "Insufficient stock"
            );
        }

        product.setStock(
                product.getStock() - quantity
        );

        productRepository.save(product);

        Reservation reservation = new Reservation();

        reservation.setRequestId(requestId);
        reservation.setProductId(productId);
        reservation.setQuantity(quantity);
        reservation.setStatus("RESERVED");
        reservation.setAttemptCount(1);
        reservation.setCreatedAt(LocalDateTime.now());
        reservation.setUpdatedAt(LocalDateTime.now());

        return reservationRepository.save(reservation);
    }
}