<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>


	<h1>Home</h1>
	<form:form action="/home/input" modelAttribute="Input" method="POST">
	
		<form:select path="type" items="${inputType}"/>
		
		<form:input path="input" placeholder="Enter first name" />
		
		<input type="submit" value="Submit">
		
	</form:form>	


</body>

</html>