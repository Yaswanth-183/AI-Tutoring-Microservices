package com.example.exp_4_saga;

import com.example.exp_4_saga.entity.Product;
import com.example.exp_4_saga.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Exp4SagaApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                Exp4SagaApplication.class,
                args
        );
    }

    @Bean
    CommandLineRunner loadData(
            ProductRepository repository) {

        return args -> {

            Product product = new Product();

            product.setId(101L);
            product.setName("Laptop");
            product.setStock(10);

            repository.save(product);

            System.out.println(
                    "Product 101 created with stock 10"
            );
        };
    }
}