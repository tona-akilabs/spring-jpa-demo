package com.example.spring_jpa_demo.repository;

import com.example.spring_jpa_demo.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
