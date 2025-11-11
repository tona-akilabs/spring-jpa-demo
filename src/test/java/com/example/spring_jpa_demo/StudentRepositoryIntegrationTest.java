package com.example.spring_jpa_demo;

import com.example.spring_jpa_demo.entities.Student;
import com.example.spring_jpa_demo.enums.Gender;
import com.example.spring_jpa_demo.repository.StudentRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

@DataJpaTest
//@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentRepositoryIntegrationTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Order(1)
    public void save() {
        Student student = new Student();
        student.setName("Tona");
        student.setAge(30);
        student.setGender(Gender.MALE);
        student.setBirthDate(LocalDate.of(1998, 1, 10));
        student = studentRepository.save(student);

        assertThat(student.getId()).isNotNull();
        assertThat(student.getName()).isEqualTo("Tona");
        assertThat(student.getAge()).isEqualTo(30);
    }

    @Test
    @Order(2)
    public void update() {
        Student student = new Student();
        student.setName("Admin");
        student.setAge(30);
        student.setGender(Gender.MALE);
        student.setBirthDate(LocalDate.of(1998, 1, 10));
        studentRepository.save(student);

        Student student2 = studentRepository.findByName("Admin");

        assertThat(student2.getId()).isNotNull();
        assertThat(student2.getName()).isEqualTo("Admin");
        assertThat(student2.getAge()).isEqualTo(30);
    }

    @Test
    @Order(3)
    public void delete() {
        Student student = new Student();
        student.setName("Admin2");
        student.setAge(30);
        student.setGender(Gender.MALE);
        student.setBirthDate(LocalDate.of(1998, 1, 10));
        studentRepository.save(student);

        studentRepository.deleteById(student.getId());

        Student student2 = studentRepository.findByName("Admin2");
        assertThat(student2).isNull();
    }
}
