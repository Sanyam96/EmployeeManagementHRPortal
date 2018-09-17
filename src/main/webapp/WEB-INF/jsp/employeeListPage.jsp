<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>

	<h3>Welcome ${username}</h3>
	<form method="post" action="logout">
			<input type="submit" value="LOGOUT">
	</form>
	<br>
	<div>
		<form method="post" action="employee" enctype="multipart/form-data">
			<input type="file" name="file" required="required" /> 
			<input type="submit" value="UPLOAD">
		</form>
	</div>
	<br>
	<div>
		<form method="post" action="employee/download" enctype="multipart/form-data">
			<input type="submit" value="DOWNLOAD">
		</form>
	</div>
	
	<table border="1">
		<tr>
			<th>id</th>
			<th>Employee Code</th>
			<th>Employee Name</th>
			<th>Location</th>
			<th>Email</th>
			<th>Date Of Birth</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.employeeCode}</td>
				<td>${employee.employeeName}</td>
				<td>${employee.location}</td>
				<td>${employee.email}</td>
				<td>${employee.dateOfBirth}</td>
				<td>
					<form method="post" action="employee/edit">
						<input type="hidden" value="${employee.id}" name="id"/>
						<input type="hidden" value="${employee.employeeCode}" name="employeeCode"/>
						<input type="hidden" value="${employee.employeeName}" name="employeeName"/>
						<input type="hidden" value="${employee.location}" name="location"/>
						<input type="hidden" value="${employee.email}" name="email"/>
						<input type="hidden" value="${employee.dateOfBirth}" name="dateOfBirth"/>
						<input type="submit" value="EDIT">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>