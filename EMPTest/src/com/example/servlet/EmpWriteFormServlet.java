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

import com.example.dto.Job;
import com.example.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmpWriteFormServlet
 */
@WebServlet("/EmpWriteFormServlet")
public class EmpWriteFormServlet extends HttpServlet {
	static Logger logger = LoggerFactory.getLogger(EmpWriteFormServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.trace("doGet함수 호출");
		List<Job> jobs = EmployeeServiceImpl.getInstance().getAllJobTitles();
		request.setAttribute("jobs", jobs);
		request.getRequestDispatcher("insert.jsp").forward(request, response);
	}	
}
