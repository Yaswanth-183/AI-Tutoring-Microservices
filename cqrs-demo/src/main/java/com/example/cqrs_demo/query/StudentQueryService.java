package com.example.cqrs_demo.query;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cqrs_demo.entity.Student;
import com.example.cqrs_demo.repository.StudentRepository;

@Service
public class StudentQueryService {

    private final StudentRepository repository;

    public StudentQueryService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudent(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}