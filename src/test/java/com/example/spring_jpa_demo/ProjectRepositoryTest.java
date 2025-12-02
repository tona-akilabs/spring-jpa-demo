package com.example.spring_jpa_demo;

import com.example.spring_jpa_demo.entities.Project;
import com.example.spring_jpa_demo.entities.Task;
import com.example.spring_jpa_demo.mapping.ProjectAndTaskCount;
import com.example.spring_jpa_demo.repository.ProjectRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;


@SpringBootTest
//@DataJpaTest
//@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Order(1)
    void testSaveProject() {
        // Create a new project instance
        Project project = new Project();
        project.setName("Test Project");
        project.setCreationAt(LocalDate.now());

        Task task1 = new Task();
        task1.setName("Task 1");
        task1.setDueDate(LocalDate.now().plusDays(7));

        Task task2 = new Task();
        task2.setName("Task 2");
        task2.setDueDate(LocalDate.now().plusDays(14));
        // Set the project for each task
        project.addTask(task1);
        project.addTask(task2);
        // Save the project to the repository
        projectRepository.save(project);

        // Optionally, you can assert that the project was saved correctly
        Assertions.assertNotNull(project.getId());
        Assertions.assertEquals("Test Project", project.getName());

        Assertions.assertEquals(2, project.getTasks().size());
        Assertions.assertNotNull(project.getTasks().get(0).getId());
        Assertions.assertNotNull(project.getTasks().get(1).getId());

    }

    @Test
    @Order(2)
    void testReadProject() {
        Optional<Project> project = projectRepository.findByName("Test Project");
        Assertions.assertNotNull(project.get().getId());
    }

    @Test
    @Order(3)
    void testRead2Project() {
        var result = entityManager
                .createQuery("SELECT p FROM Project p", Project.class)
                .getResultList();
        Assertions.assertEquals(result.size(), 1);
    }

    @Test
    @Order(4)
    void testRead3Project() {
        var result = entityManager
                .createQuery("SELECT p FROM Project p WHERE p.name = :name", Project.class)
                .setParameter("name", "Test Project")
                .getSingleResult();
        Assertions.assertNotNull(result.getId());
    }

    @Test
    @Order(5)
    void testRead4Project() {
        String jpql =
                "SELECT new com.example.spring_jpa_demo.mapping.ProjectAndTaskCount(p.id, p.name, COUNT(t)) " +
                        "FROM Project p JOIN p.tasks t " +
                        "WHERE p.name = :name " +
                        "GROUP BY p.id, p.name";

        ProjectAndTaskCount result = entityManager
                .createQuery(jpql, ProjectAndTaskCount.class)
                .setParameter("name", "Test Project")
                .getSingleResult();
        Assertions.assertNotNull(result.getId());
    }

    @Test
    @Order(6)
    void testRead5Project() {
        var result = projectRepository.findProjectAndTaskCountByName("Test Project");
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getId());
        Assertions.assertEquals(result.getCount(), 2);
    }

    @Test
    @Order(10)
    void testDeleteProject() {
        Optional<Project> project = projectRepository.findByName("Test Project");
        projectRepository.deleteById(project.get().getId());
        Assertions.assertNotNull(project.get().getId());
    }
}
