<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>


	<table border="1">
		<tr>
			<th>Title</th>
			<th>Test Score</th>
			<th>Quiz Score</th>
			<th>Lab Score</th>
			<th>Project Score</th>
			<th>OverAll Rating(%)</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.title}</td>
				<td>${list.testScore}</td>
				<td>${list.quizScore}</td>
				<td>${list.labScore}</td>
				<td>${list.projectScore}</td>
				<td>${list.tot}</td>
			</tr>
		</c:forEach>
	</table>

</body>

</html>