package com.example.consumerest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

//	@JsonProperty("Id")
//	private String employeeId;
	@JsonProperty("employeeName")
	private String employeeName2;
	private String employeeRole;

//	public String getEmployeeId() {
//		return employeeId;
//	}
//
//	public void setEmployeeId(String employeeId) {
//		this.employeeId = employeeId;
//	}

	public String getEmployeeName2() {
		return employeeName2;
	}

	public void setEmployeeName2(String employeeName2) {
		this.employeeName2 = employeeName2;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	@Override
	public String toString() {
		return "Employee{" + "name=" + employeeName2 + ", role=" + employeeRole + "}";
	}
}

