package com.example.spring_jpa_demo.repository;

import com.example.spring_jpa_demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String studentName);
}
