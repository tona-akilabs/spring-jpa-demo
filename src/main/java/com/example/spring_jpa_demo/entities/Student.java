package com.example.spring_jpa_demo.entities;

import com.example.spring_jpa_demo.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    @Column
    private String name;

    @Transient
    private Integer age;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
