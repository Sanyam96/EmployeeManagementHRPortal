<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form method="post" action="login">
		<input type="text" name="username" required="required" placeholder="username"/> 
		<br><br>
		<input type="password" name="password" required="required" placeholder="password" /> 
		<br><br>
		<input type="submit" value="LOGIN">
	</form>
	<h4>${message}</h4>
</body>
</html>