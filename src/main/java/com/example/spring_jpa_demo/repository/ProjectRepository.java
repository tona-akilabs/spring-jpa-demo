package com.example.spring_jpa_demo.repository;

import com.example.spring_jpa_demo.model.Project;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
