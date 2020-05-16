package com.example.consumerest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.example.consumerest.model.Employee;

@Service
public class EmployeeService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public List<Employee> getAllEmployeesEntity() {
		RestTemplate restTemplate = new RestTemplate();
		List<Employee> employeeList = new ArrayList<Employee>();
		ResponseEntity<Employee[]> response = restTemplate.getForEntity("http://localhost:8080/list", Employee[].class);
		Employee[] employees = response.getBody();
		employeeList = Arrays.asList(employees);
		for (Employee emp : employees) {
			log.info(emp.toString());
		}
		return employeeList;

	}
	
	public List<Employee> getAllEmployeesObject() {
		RestTemplate restTemplate = new RestTemplate();
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee[] employees = restTemplate.getForObject("http://localhost:8080/list", Employee[].class);
		employeeList = Arrays.asList(employees);
		for (Employee emp : employees) {
			log.info(emp.toString());
		}
		return employeeList;

	}
	
	public Employee addEmployee(Employee employee) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Employee> request = new HttpEntity<>(employee);
		Employee response = restTemplate.postForObject("http://localhost:8080/save", request, Employee.class);
		log.info(response.toString());
		return response;
	}
	
	public ResponseEntity<Employee> addEmployeeViaExchange(Employee employee) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Employee> request = new HttpEntity<>(employee);
		ResponseEntity<Employee> response = restTemplate.exchange("http://localhost:8080/save", HttpMethod.POST, request, Employee.class);
		log.info(response.toString());
		return response;
	}
	
	public  List<Employee> getEmployeeViaExchange() {
		RestTemplate restTemplate = new RestTemplate();
//		HttpEntity<Employee> request = new HttpEntity<Employee>;
		ResponseEntity<Employee[]> response = restTemplate.exchange("http://localhost:8080/list", HttpMethod.GET, null, Employee[].class);
		Employee[] employees = response.getBody();
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = Arrays.asList(employees);
		for (Employee emp : employees) {
			log.info(emp.toString());
		}
		return employeeList;
	}

}
