package com.aitutor.questionservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.aitutor.questionservice.model.Question;

@Service
public class QuestionService {

    private List<Question> questions = new ArrayList<>(Arrays.asList(

            new Question(1L, "What is Java?"),

            new Question(2L, "Explain the four pillars of OOP."),

            new Question(3L, "What is Spring Boot?")

    ));

    public List<Question> getAllQuestions() {
        return questions;
    }

    public Question getRandomQuestion() {

        Random random = new Random();

        return questions.get(random.nextInt(questions.size()));

    }

    // NEW METHOD
    public Question getQuestionById(Long id) {

        for (Question question : questions) {

            if (question.getId().equals(id)) {
                return question;
            }

        }

        return null;
    }

    public Question addQuestion(Question question) {

        questions.add(question);

        return question;

    }

    public Question updateQuestion(Long id, Question updatedQuestion) {

        for (Question question : questions) {

            if (question.getId().equals(id)) {

                question.setQuestion(updatedQuestion.getQuestion());

                return question;

            }

        }

        return null;
    }

    public void deleteQuestion(Long id) {

        questions.removeIf(question -> question.getId().equals(id));

    }

}