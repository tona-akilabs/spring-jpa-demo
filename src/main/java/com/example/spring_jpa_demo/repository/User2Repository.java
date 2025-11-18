package com.example.spring_jpa_demo.repository;

import com.example.spring_jpa_demo.entities.User2;
import org.springframework.data.jpa.repository.JpaRepository;


public interface User2Repository extends JpaRepository<User2, Long> {
    User2 findByUsername(String username);
}
