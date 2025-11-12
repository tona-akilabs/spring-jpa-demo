package com.example.spring_jpa_demo.entities;

import com.example.spring_jpa_demo.listeners.AuditTrailListener;
import jakarta.persistence.*;

@EntityListeners(AuditTrailListener.class)
@Entity
@Table(name = "simple_user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String userName;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Transient
    private String fullName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }
}
