package com.aitutor.evaluation_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aitutor.evaluation_service.model.Answer;
import com.aitutor.evaluation_service.service.EvaluationService;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @PostMapping("/evaluate")
    public String evaluate(@RequestBody Answer answer) {

        return evaluationService.evaluateAnswer(answer);

    }

}