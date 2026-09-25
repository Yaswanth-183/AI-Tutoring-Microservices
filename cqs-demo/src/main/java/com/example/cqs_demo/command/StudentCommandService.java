package com.example.cqs_demo.command;

import com.example.cqs_demo.entity.Student;
import com.example.cqs_demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentCommandService {

    private final StudentRepository studentRepository;

    public StudentCommandService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(student.getName());
        existingStudent.setDepartment(student.getDepartment());

        studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }

        studentRepository.deleteById(id);
    }
}