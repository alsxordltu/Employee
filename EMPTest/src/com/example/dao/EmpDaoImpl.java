package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.dto.Employee;
import com.example.dto.EmployeeUpdate;
import com.example.dto.Job;

public class EmpDaoImpl implements EmpDao {
	
	//singleton 처리
	private EmpDaoImpl() {
	}

	private static EmpDaoImpl instance = new EmpDaoImpl();

	public static EmpDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Employee> getAllEmployees(SqlSession session) {
		String stmt = "com.example.EmployeeMapper.findAll";
		return session.selectList(stmt);
	}

	@Override
	public List<Job> getAllJobTitles(SqlSession session) {
		String stmt = "com.example.EmployeeMapper.jobList";
		return session.selectList(stmt);
	}

	@Override
	public int inputEmployee(SqlSession session, Employee employee) {
		String stmt = "com.example.EmployeeMapper.insertEmployee";
		return session.update(stmt, employee);
	}

	@Override
	public Employee getEmpInfo(SqlSession session, int empId) {
		String stmt = "com.example.EmployeeMapper.empInfo";
		return session.selectOne(stmt, empId);
	}

	@Override
	public int updateEmployee(SqlSession session, EmployeeUpdate employeeUpdate) {
		String stmt = "com.example.EmployeeMapper.updateEmployee";
		return session.update(stmt, employeeUpdate);
	}

	@Override
	public int deleteEmployee(SqlSession session, int empId) {
		String stmt = "com.example.EmployeeMapper.deleteEmployee";
		return session.update(stmt,empId);
	}

}
