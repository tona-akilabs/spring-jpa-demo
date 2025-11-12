package com.example.spring_jpa_demo.entities;

import jakarta.persistence.*;


@Entity
public class Company {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phone;

    @Embedded
    private ContactPerson contactPerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }
}
