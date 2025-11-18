package com.example.spring_jpa_demo;

import com.example.spring_jpa_demo.entities.Address;
import com.example.spring_jpa_demo.entities.User2;
import com.example.spring_jpa_demo.repository.User2Repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserRepository2IntegrationTest {

    @Autowired
    private User2Repository userRepository;

    @Test
    public void create() {
        User2 user = new User2();
        user.setUsername("Admin");
        Address address = new Address();
        address.setCity("Phnom Penh");
        user.setAddress(address);

        user = userRepository.save(user);

        Assertions.assertThat(user.getId()).isNotNull();
    }

    @Test
    public void find() {
        User2 user = userRepository.findByUsername("Admin");
        Assertions.assertThat(user.getId()).isNotNull();
    }
}
