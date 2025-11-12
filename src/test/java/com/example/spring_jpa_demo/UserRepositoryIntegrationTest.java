package com.example.spring_jpa_demo;

import com.example.spring_jpa_demo.entities.User;
import com.example.spring_jpa_demo.repository.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save() {
        User user = new User();
        user.setUserName("Admin");
        user.setFirstName("Tona");
        user.setLastName("Chheun");
        user = userRepository.save(user);

        assertThat(user.getId()).isNotNull();
    }
}
