package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.dto.Employee;
import com.example.dto.EmployeeUpdate;
import com.example.dto.Job;

public interface EmpDao {
	List<Employee> getAllEmployees(SqlSession session); 
	List<Job> getAllJobTitles(SqlSession session);
	int inputEmployee(SqlSession session, Employee employee);
	Employee getEmpInfo(SqlSession session, int empId);
	int updateEmployee(SqlSession session, EmployeeUpdate employeeUpdate);
	int deleteEmployee(SqlSession session, int empId);
	
}
