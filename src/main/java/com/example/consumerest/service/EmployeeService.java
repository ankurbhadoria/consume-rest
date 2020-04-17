package com.example.consumerest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.consumerest.model.Employee;

@Service
public class EmployeeService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public List<Employee> getAllEmployees() {
		RestTemplate restTemplate = new RestTemplate();
		List<Employee> employeeList = new ArrayList<Employee>();
		ResponseEntity<Employee[]> response =
				  restTemplate.getForEntity(
				  "http://localhost:8080/list",
				  Employee[].class);
				Employee[] employees = response.getBody();
				employeeList = Arrays.asList(employees);
				for(Employee emp : employees) {
					log.info(emp.toString());
				}
		return employeeList;
		
	}

}