package com.example.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dto.Employee;
import com.example.dto.EmployeeUpdate;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmpUpdateServlet
 */
@WebServlet("/EmpUpdateServlet")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));	
		String empJobTitle = request.getParameter("empJobTitle");
		int empSalary = Integer.parseInt(request.getParameter("empSalary"));
		
		EmployeeUpdate empUpdate = new EmployeeUpdate(empId, empJobTitle, empSalary);
		
		EmployeeService service = EmployeeServiceImpl.getInstance();
		
		int result = service.updateEmployee(empUpdate);
		if(result == 1){
			response.sendRedirect(request.getContextPath() + "/EmpListServlet");
		}
	}

}
