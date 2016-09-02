package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmpDeleteServlet
 */
@WebServlet("/EmpDeleteServlet")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		EmployeeService service = EmployeeServiceImpl.getInstance();
		int result = service.deleteEmployee(empId);
		if(result == 1){
			request.getRequestDispatcher("/EmpListServlet").forward(request, response);
		}
		
	}

}
