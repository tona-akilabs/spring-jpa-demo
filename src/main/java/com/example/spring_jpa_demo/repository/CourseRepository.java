package com.example.spring_jpa_demo.repository;

import com.example.spring_jpa_demo.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
