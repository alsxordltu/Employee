package com.example.test;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dto.Employee;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;


public class ServiceTest {
	static Logger logger = LoggerFactory.getLogger(ServiceTest.class);

	@Test
	public void test() {
		EmployeeService service = EmployeeServiceImpl.getInstance();
		int employee = service.deleteEmployee(313);
		logger.trace("{}",employee);
		
	}

}
