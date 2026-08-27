package aitutor.postman_loop_service.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public String createOrder(@RequestBody String order) {

        System.out.println(
                "Received Order: " + order
        );

        return "Order received successfully: " + order;
    }
}