package com.example.spring_jpa_demo;

import com.example.spring_jpa_demo.entities.Company;
import com.example.spring_jpa_demo.entities.ContactPerson;
import com.example.spring_jpa_demo.repository.CompanyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CompanyRepositoryIntegrationTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void save() {
        Company company = new Company();
        company.setName("STR Development");
        company.setPhone("023-000-000");
        company.setAddress("Phnom Penh, Cambodia");
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setFirstName("Tona");
        contactPerson.setLastName("Chheun");
        contactPerson.setPhone("012-000-000");
        company.setContactPerson(contactPerson);

        company = companyRepository.save(company);
        Assertions.assertThat(company.getId()).isNotNull();
    }
}
