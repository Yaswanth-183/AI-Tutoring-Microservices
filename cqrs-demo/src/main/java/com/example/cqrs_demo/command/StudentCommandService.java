package com.example.cqrs_demo.command;

import org.springframework.stereotype.Service;

import com.example.cqrs_demo.entity.Student;
import com.example.cqrs_demo.repository.StudentRepository;

@Service
public class StudentCommandService {

    private final StudentRepository repository;

    public StudentCommandService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Long id, Student student) {

        Student existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(student.getName());
        existingStudent.setDepartment(student.getDepartment());

        return repository.save(existingStudent);
    }

    public void deleteStudent(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }

        repository.deleteById(id);
    }
}