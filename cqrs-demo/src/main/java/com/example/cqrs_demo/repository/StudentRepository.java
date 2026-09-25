package com.example.cqrs_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cqrs_demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}