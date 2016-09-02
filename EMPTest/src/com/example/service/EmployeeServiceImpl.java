package com.example.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dao.EmpDao;
import com.example.dao.EmpDaoImpl;
import com.example.dto.Employee;
import com.example.dto.EmployeeUpdate;
import com.example.dto.Job;
import com.example.util.MyBatisUtil;

public class EmployeeServiceImpl implements EmployeeService {
	static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	//singleton 처리
	private EmployeeServiceImpl() {
	}

	private static EmployeeServiceImpl instance = new EmployeeServiceImpl();

	public static EmployeeServiceImpl getInstance() {
		return instance;
	}
	
	EmpDao eDao = EmpDaoImpl.getInstance();

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = null;
		try(SqlSession session = MyBatisUtil.getInstance().getSession()){
			employees = eDao.getAllEmployees(session);
		}
		return employees;
	}

	@Override
	public List<Job> getAllJobTitles() {
		List<Job> jobs = null;
		try(SqlSession session = MyBatisUtil.getInstance().getSession()){
			jobs = eDao.getAllJobTitles(session);
		}
		return jobs;
	}

	@Override
	public int inputEmployee(Employee employee) {
		try (SqlSession session = MyBatisUtil.getInstance().getSession()) {
			int result = eDao.inputEmployee(session, employee);
			if (result == 1) {
				session.commit();
			}
			return result;
		}
	}

	@Override
	public Employee getEmpInfo(int empId) {
		Employee employee = null;
		try(SqlSession session = MyBatisUtil.getInstance().getSession()){
			employee = eDao.getEmpInfo(session, empId);
		}
		return employee;
	}

	@Override
	public int updateEmployee(EmployeeUpdate employeeUpdate) {
		try (SqlSession session = MyBatisUtil.getInstance().getSession()) {
			int result = eDao.updateEmployee(session, employeeUpdate);
			if (result == 1) {
				session.commit();
			}
			return result;
		}
	}

	@Override
	public int deleteEmployee(int empId) {
		try (SqlSession session = MyBatisUtil.getInstance().getSession()) {
			logger.trace("session 연결 성공");
			int result = eDao.deleteEmployee(session, empId);
			if (result == 1) {
				session.commit();
			}
			return result;
		}
	}

}
