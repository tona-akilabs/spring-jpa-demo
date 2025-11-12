package com.example.spring_jpa_demo.repository;

import com.example.spring_jpa_demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
