package com.aitutor.questionservice.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aitutor.questionservice.dto.CreateQuestionRequest;
import com.aitutor.questionservice.dto.QuestionResponse;
import com.aitutor.questionservice.service.QuestionService;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(
            QuestionService questionService) {

        this.questionService =
                questionService;
    }


    @PostMapping
    public ResponseEntity<QuestionResponse>
    createQuestion(
            @Valid
            @RequestBody
            CreateQuestionRequest request) {

        QuestionResponse response =
                questionService
                        .createQuestion(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponse>
    getQuestion(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                questionService
                        .getQuestion(id)
        );
    }


    @GetMapping
    public ResponseEntity<List<QuestionResponse>>
    getAllQuestions() {

        return ResponseEntity.ok(
                questionService
                        .getAllQuestions()
        );
    }


    @GetMapping("/topic/{topic}")
    public ResponseEntity<List<QuestionResponse>>
    getByTopic(
            @PathVariable String topic) {

        return ResponseEntity.ok(
                questionService
                        .getByTopic(topic)
        );
    }


    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<QuestionResponse>
    deactivateQuestion(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                questionService
                        .deactivateQuestion(id)
        );
    }
}