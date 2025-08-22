package com.example.spring_jpa_demo;

import com.example.spring_jpa_demo.model.Project;
import com.example.spring_jpa_demo.model.Task;
import com.example.spring_jpa_demo.repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Arrays;


//@SpringBootTest
@DataJpaTest
@ActiveProfiles("test")
public class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
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
        project.setTasks(Arrays.asList(task1, task2));
        // Save the project to the repository
        projectRepository.save(project);

        // Optionally, you can assert that the project was saved correctly
        Assertions.assertNotNull(project.getId());
        Assertions.assertEquals("Test Project", project.getName());

        Assertions.assertEquals(2, project.getTasks().size());
        Assertions.assertNotNull(project.getTasks().get(0).getId());
        Assertions.assertNotNull(project.getTasks().get(1).getId());

    }
}
// @DataJpaTest
