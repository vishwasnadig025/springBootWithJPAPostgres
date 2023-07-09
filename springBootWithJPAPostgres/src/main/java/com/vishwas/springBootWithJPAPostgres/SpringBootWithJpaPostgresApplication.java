package com.vishwas.springBootWithJPAPostgres;

import com.vishwas.springBootWithJPAPostgres.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootWithJpaPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithJpaPostgresApplication.class, args);
	}

}
