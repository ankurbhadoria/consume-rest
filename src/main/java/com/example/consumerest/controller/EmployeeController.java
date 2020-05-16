package com.example.consumerest.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumerest.model.Employee;
import com.example.consumerest.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "employees",method = RequestMethod.GET)   // or use @GetMapping
    public List<Employee> getAllEmployeesEntity() {
//        return employeeService.getAllEmployeesEntity();
		return employeeService.getEmployeeViaExchange();
    }
	
	@RequestMapping(value = "employeesList",method = RequestMethod.GET)   // or use @GetMapping
    public List<Employee> getAllEmployeesObject() {
        return employeeService.getAllEmployeesObject();
    }
	
	@RequestMapping(value = "save",method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> addEmployee(
    		@RequestBody Employee employee) {
        Employee emp = employeeService.addEmployee(employee);
        
        if(Objects.isNull(emp)) {
        	return ResponseEntity.ok("Failed to add employee!");
        }
        return ResponseEntity.ok(emp); 
    }
	
	@RequestMapping(value = "add",method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> addEmployeeViaExchange(
    		@RequestBody Employee employee) {
        ResponseEntity<Employee> empEntity = employeeService.addEmployeeViaExchange(employee);
        empEntity.getStatusCode();
        empEntity.getBody();
        
        if(Objects.isNull(empEntity)) {
        	return ResponseEntity.ok("Failed to add employee!");
        }
        return empEntity; 
    }

}
