package com.example.spring_jpa_demo;

import com.example.spring_jpa_demo.entities.Course;
import com.example.spring_jpa_demo.repository.CourseRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseRepositoryIntegrationTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void save() {
        Course course = new Course();
        course.setId(1L);
        course.setName("Spring framework");

        course = courseRepository.save(course);
        Assertions.assertThat(course.getId()).isEqualTo(1L);
    }

    @Test
    public void read() {
        Course course = courseRepository.findById(1L).get();

        Assertions.assertThat(course.getName()).isEqualTo("Spring framework");
    }
}
