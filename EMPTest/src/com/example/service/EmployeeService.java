package com.example.service;

import java.util.List;

import com.example.dto.Employee;
import com.example.dto.EmployeeUpdate;
import com.example.dto.Job;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	List<Job> getAllJobTitles();
	int inputEmployee(Employee employee);
	Employee getEmpInfo(int empId);
	int updateEmployee(EmployeeUpdate employeeUpdate);
	int deleteEmployee(int empId);
}
