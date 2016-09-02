package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dto.Employee;
import com.example.dto.Job;
import com.example.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmpRetrieveServlet
 */
@WebServlet("/EmpRetrieveServlet")
public class EmpRetrieveServlet extends HttpServlet {
	static Logger logger = LoggerFactory.getLogger(EmpRetrieveServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		Employee employee = EmployeeServiceImpl.getInstance().getEmpInfo(empId);
		List<Job> jobs = EmployeeServiceImpl.getInstance().getAllJobTitles();
		request.setAttribute("jobs", jobs);
		request.setAttribute("employeeInfo", employee);
		request.getRequestDispatcher("retrieve.jsp").forward(request, response);
	}
}
