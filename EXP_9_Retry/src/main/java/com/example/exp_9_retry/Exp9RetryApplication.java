package com.example.exp_9_retry;

import com.example.exp_9_retry.entity.Product;
import com.example.exp_9_retry.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Exp9RetryApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                Exp9RetryApplication.class,
                args
        );
    }

    @Bean
    CommandLineRunner initialize(
            ProductRepository repository) {

        return args -> {

            if (!repository.existsById(101L)) {

                Product product = new Product();

                product.setId(101L);
                product.setName("Laptop");
                product.setStock(10);

                repository.save(product);

                System.out.println(
                        "Product 101 initialized with stock 10"
                );
            }
        };
    }
}