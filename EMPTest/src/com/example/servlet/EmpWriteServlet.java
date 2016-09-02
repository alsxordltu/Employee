package com.example.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dto.Employee;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmpWriteServlet
 */
@WebServlet("/EmpWriteServlet")
public class EmpWriteServlet extends HttpServlet {
	static Logger logger = LoggerFactory.getLogger(EmpWriteServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		String empJobTitle = request.getParameter("empJobTitle");
		int empManagerId = Integer.parseInt(request.getParameter("empManagerId"));
		Date empHireDate = new Date(); 
		int empSalary = Integer.parseInt(request.getParameter("empSalary"));
		
		Employee employee = new Employee(empId, empName, empJobTitle, empManagerId, empHireDate, empSalary);
		
		EmployeeService service = EmployeeServiceImpl.getInstance();
		
		int result = service.inputEmployee(employee);
		if( result == 1){
			logger.trace("추가 성공");
			response.sendRedirect(request.getContextPath() + "/EmpListServlet");
		}else{
			logger.trace("추가 실패");
		}

		
		 
	}

}
