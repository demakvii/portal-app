<%@page import="com.techlabs.services.DepartmentService"%>
<%@page import="com.techlabs.entity.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	List<Department> deptList = new DepartmentService().getDeptList();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Department</title>
</head>
<body>

	<h1>Manage Department</h1>
	<%
		if (!deptList.isEmpty()) {
	%>
	<table>
		<tr>
			<th>Department Id</th>
			<th>Department Name</th>
			<th>Department Location</th>
		</tr>
		<%
			for (Department department : deptList) {
		%>
		<tr>
			<td><%=department.getDeptId()%></td>
			<td><%=department.getDeptName()%></td>
			<td><%=department.getDeptLocation()%></td>
			<td><a
				href="editDepartment.jsp?deptId=<%=department.getDeptId()%>">Edit</a></td>
			<td><a
				href="deleteDepartment.jsp?deptId=<%=department.getDeptId()%>">Delete</a></td>
		</tr>
		<%
			}
		%>

	</table>
	<%
		} else {
			out.print("<h3>Sorry , there are no department present right now</h3>");
			out.print("To add department <a href='addDepartment.html'>click here</a>");
		}
	%>

</body>
</html>