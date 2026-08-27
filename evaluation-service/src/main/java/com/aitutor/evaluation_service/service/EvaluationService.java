package com.aitutor.evaluation_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aitutor.evaluation_service.model.Answer;
import com.aitutor.evaluation_service.publisher.AnswerPublisher;
import com.aitutor.evaluation_service.publisher.WorkQueuePublisher;

@Service
public class EvaluationService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WorkQueuePublisher workQueuePublisher;

    private AnswerPublisher answerPublisher;
    public String evaluateAnswer(Answer answer) {

        String question = restTemplate.getForObject(
                "http://localhost:9091/questions/" + answer.getQuestionId(),
                String.class);
//Exp 7
//        answerPublisher.publish(
//                "Student answered Question "
//                + answer.getQuestionId());
        workQueuePublisher.sendTask(
                "Evaluate Question "
                + answer.getQuestionId());

        return "Question Received: "
                + question
                + "\nAnswer Received: "
                + answer.getAnswer()
                + "\nEvaluation Completed Successfully.";

    }

}