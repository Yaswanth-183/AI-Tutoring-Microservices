package com.example.cqs_demo.query;

import com.example.cqs_demo.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/queries/students")
public class StudentQueryController {

    private final StudentQueryService queryService;

    public StudentQueryController(StudentQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return queryService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return queryService.getStudentById(id);
    }
}