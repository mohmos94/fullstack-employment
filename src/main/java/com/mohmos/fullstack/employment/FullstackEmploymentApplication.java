package com.mohmos.fullstack.employment;

import com.mohmos.fullstack.employment.Model.Employee;
import com.mohmos.fullstack.employment.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FullstackEmploymentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FullstackEmploymentApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee("Mostafa", "Mohammedi", "mosti94@hotmail.com", "project lead"));
		emp.add(new Employee("Smane", "Mohammedi", "mosti94@hotmail.com", "senior tech lead"));
		emp.add(new Employee("Asie", "Mohammedi", "mosti94@hotmail.com", "developer"));
		//employeeRepository.saveAll(emp);

	}
}
