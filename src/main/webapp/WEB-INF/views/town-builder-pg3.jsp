<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/">Home</a>
<table>
<tr><th>Species</th><th>Age</th><th>Gender</th><th>Job</th><th>First Name</th><th>Last Name</th></tr>
<c:forEach items="${testTown}" var="thing">
	<c:forEach items="${thing.members}" var="person">
		<tr>
		<td>${person.species.name}</td>
		<td>${person.age}</td>
		<td>${person.gender}</td>
		<td>${person.job}</td>
		<td>${person.firstName}</td>
		<td>${person.lastName}</td>
		</tr>
	</c:forEach>
</c:forEach>
</table>
</body>
</html>