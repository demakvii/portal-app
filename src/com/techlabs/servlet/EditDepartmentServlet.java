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
 * Servlet implementation class EditDepartmentServlet
 */
@WebServlet("/editDepartment")
public class EditDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditDepartmentServlet() {
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
		String resultDeptId = request.getSession().getAttribute("deptId")
				.toString();
		if (resultDeptId != null) {
			Department editDept = new Department(
					Integer.parseInt(resultDeptId),
					request.getParameter("deptname"),
					request.getParameter("deptlocation"));

			boolean result = new DepartmentService().editDepartment(editDept);
			if (result) {
				response.sendRedirect("manageDepartment.jsp");
			} else {
				response.sendRedirect("editDepartment.jsp?deptId="
						+ resultDeptId);
			}
		} else {
			response.sendRedirect("manageDepartment.jsp");
		}
	}

}
