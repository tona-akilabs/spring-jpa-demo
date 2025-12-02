package com.example.spring_jpa_demo.repository;

import com.example.spring_jpa_demo.entities.Project;
import com.example.spring_jpa_demo.mapping.ProjectAndTaskCount;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@Transactional
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findByName(String name);

    @Query("""
        SELECT new com.example.spring_jpa_demo.mapping.ProjectAndTaskCount(p.id, p.name, COUNT(t))
        FROM Project p
        JOIN p.tasks t
        WHERE p.name = :name
        GROUP BY p.id, p.name
        """)
    ProjectAndTaskCount findProjectAndTaskCountByName(@Param("name") String name);
}
