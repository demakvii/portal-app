package com.techlabs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlabs.entity.Department;
import com.techlabs.services.DepartmentService;

/**
 * Servlet implementation class AddDepartmentServlet
 */
@WebServlet("/addDepartment")
public class AddDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDepartmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DepartmentService service = new DepartmentService();
		boolean result= service.addDepartment(new Department(Integer.parseInt(request
				.getParameter("deptid")), request.getParameter("deptname"),
				request.getParameter("deptlocation")));
		if(result)
			response.sendRedirect("home.jsp");
		else{
			response.sendRedirect("error.jsp");
		}
	}

}
