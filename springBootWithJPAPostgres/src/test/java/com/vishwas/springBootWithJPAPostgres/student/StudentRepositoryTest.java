package com.vishwas.springBootWithJPAPostgres.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void checkIfStudentEmailExists() {
        //given
        Student student = new Student("Vishwas Nadig", "vishwasnadig.v@gmail.com", LocalDate.of(1994,8,25));
        underTest.save(student);
        //when
        Optional expected = underTest.findStudentByEmail(student.getEmail());

        //Then
        assertThat(expected).isPresent();

    }

    @Test
    void checkIfStudentEmailNotExists() {
        //given
        String email = "vishwasnadig025@gmail.com";
        //when
        Optional expected = underTest.findStudentByEmail(email);

        //Then
        assertThat(expected).isNotPresent();

    }
}