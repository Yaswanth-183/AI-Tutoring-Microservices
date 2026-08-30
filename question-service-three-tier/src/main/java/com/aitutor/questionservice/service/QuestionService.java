package com.aitutor.questionservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aitutor.questionservice.dto.CreateQuestionRequest;
import com.aitutor.questionservice.dto.QuestionResponse;
import com.aitutor.questionservice.entity.Question;
import com.aitutor.questionservice.exception.QuestionNotFoundException;
import com.aitutor.questionservice.repository.QuestionRepository;

@Service
@Transactional
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(
            QuestionRepository questionRepository) {

        this.questionRepository =
                questionRepository;
    }


    public QuestionResponse createQuestion(
            CreateQuestionRequest request) {

        Question question =
                new Question(
                        request.questionText(),
                        request.topic(),
                        request.difficulty()
                );

        Question saved =
                questionRepository.save(question);

        return toResponse(saved);
    }


    @Transactional(readOnly = true)
    public QuestionResponse getQuestion(Long id) {

        Question question =
                questionRepository
                        .findById(id)
                        .orElseThrow(
                            () -> new QuestionNotFoundException(id)
                        );

        return toResponse(question);
    }


    @Transactional(readOnly = true)
    public List<QuestionResponse> getAllQuestions() {

        return questionRepository
                .findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }


    @Transactional(readOnly = true)
    public List<QuestionResponse> getByTopic(
            String topic) {

        return questionRepository
                .findByTopicIgnoreCase(topic)
                .stream()
                .map(this::toResponse)
                .toList();
    }


    public QuestionResponse deactivateQuestion(
            Long id) {

        Question question =
                questionRepository
                        .findById(id)
                        .orElseThrow(
                            () -> new QuestionNotFoundException(id)
                        );

        question.setActive(false);

        return toResponse(
                questionRepository.save(question)
        );
    }


    private QuestionResponse toResponse(
            Question question) {

        return new QuestionResponse(
                question.getId(),
                question.getQuestionText(),
                question.getTopic(),
                question.getDifficulty(),
                question.isActive()
        );
    }
}