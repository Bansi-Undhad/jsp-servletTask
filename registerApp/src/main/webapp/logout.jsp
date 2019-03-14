<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Log Out sucessfully</h1>
	<%@page import="com.javaWebApplication.bean.User"%>
	<%
	User user = new User();
	user.setFname("");
	user.setLname("");
	user.setDob("");
	user.setPassword("");
	user.setEmail("");
	user.setGender("");
	user.setLang("");	
	session.invalidate(); %>
	<a href="index.jsp">Home</a>
	
</body>
</html>