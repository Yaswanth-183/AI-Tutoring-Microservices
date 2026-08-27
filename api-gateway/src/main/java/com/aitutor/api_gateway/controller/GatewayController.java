package com.aitutor.api_gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class GatewayController {

    @Autowired
    private RestTemplate restTemplate;

    // Route GET requests to Question Service
    @GetMapping("/questions")
    public String getQuestions() {

        return restTemplate.getForObject(
                "http://localhost:9091/questions",
                String.class);

    }

    // Route GET Random Question
    @GetMapping("/questions/random")
    public String getRandomQuestion() {

        return restTemplate.getForObject(
                "http://localhost:9091/questions/random",
                String.class);

    }

    // Route GET Question By Id
    @GetMapping("/questions/{id}")
    public String getQuestionById(@PathVariable Long id) {

        return restTemplate.getForObject(
                "http://localhost:9091/questions/" + id,
                String.class);

    }

    // Route POST request to Evaluation Service
    @PostMapping("/evaluation/evaluate")
    public String evaluateAnswer(@RequestBody String body) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(
                        "http://localhost:9092/evaluation/evaluate",
                        request,
                        String.class);

        return response.getBody();

    }

}