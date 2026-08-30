package com.aitutor.cleanquestion.adapter.in.web;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aitutor.cleanquestion.application.port.in.QuestionUseCase;
import com.aitutor.cleanquestion.domain.Question;
import com.aitutor.cleanquestion.dto.CreateQuestionRequest;
import com.aitutor.cleanquestion.dto.QuestionResponse;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    private final QuestionUseCase questionUseCase;


    public QuestionController(
            QuestionUseCase questionUseCase) {

        this.questionUseCase = questionUseCase;
    }


    @PostMapping
    public ResponseEntity<QuestionResponse>
    createQuestion(
            @Valid
            @RequestBody
            CreateQuestionRequest request) {

        Question question =
                questionUseCase.createQuestion(

                        request.questionText(),

                        request.topic(),

                        request.difficulty()
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                    QuestionResponse.from(question)
                );
    }


    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponse>
    getQuestion(
            @PathVariable Long id) {

        Question question =
                questionUseCase.getQuestion(id);

        return ResponseEntity.ok(
                QuestionResponse.from(question)
        );
    }


    @GetMapping
    public ResponseEntity<List<QuestionResponse>>
    getAllQuestions() {

        List<QuestionResponse> response =
                questionUseCase
                        .getAllQuestions()
                        .stream()
                        .map(QuestionResponse::from)
                        .toList();

        return ResponseEntity.ok(response);
    }


    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<QuestionResponse>
    deactivateQuestion(
            @PathVariable Long id) {

        Question question =
                questionUseCase
                        .deactivateQuestion(id);

        return ResponseEntity.ok(
                QuestionResponse.from(question)
        );
    }
}