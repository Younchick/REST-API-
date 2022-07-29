package com.example.RESTfull.API;

import com.example.RESTfull.API.Model.Employee;
import com.example.RESTfull.API.Services.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
@EnableJpaRepositories
public class ResTfullApiApplication {

	public static void main(String[] args) {


		SpringApplication.run(ResTfullApiApplication.class, args);
	}

}
