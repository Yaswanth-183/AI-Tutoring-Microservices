package com.example.cqs_demo.command;

import com.example.cqs_demo.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commands/students")
public class StudentCommandController {

    private final StudentCommandService commandService;

    public StudentCommandController(StudentCommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        commandService.createStudent(student);
        return ResponseEntity.ok("Student created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        commandService.updateStudent(id, student);
        return ResponseEntity.ok("Student updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        commandService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}