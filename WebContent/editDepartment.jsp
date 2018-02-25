<%@page import="com.techlabs.services.DepartmentService"%>
<%@page import="com.techlabs.entity.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int deptId = Integer.parseInt(request.getParameter("deptId")
			.toString());
	Department editDept = new DepartmentService()
			.getDepartmentById(deptId);
	request.getSession().setAttribute("deptId", deptId);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Department</title>
</head>
<body>
	<h1>Edit Department Details</h1>
	<form action="editDepartment" method="post">
		Department id :<%=deptId%>
		<br> <br> Department Name <input type="text" name="deptname"
			value="<%=editDept.getDeptName()%>"> <br> <br>
		Department Location <input type="text"
			name="deptlocation" value="<%=editDept.getDeptLocation()%>">
		<br> <br>
		<input type="submit" value="Add Department">
	</form>
</body>
</html>