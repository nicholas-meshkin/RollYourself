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
<tr><th>Species</th><th>PCT</th>
<c:forEach items="${popDist.popDist}" var="thing">
<tr>
<td>${thing.species.name}</td>
<td>${thing.pct}</td>
</tr>
</c:forEach>
</table>
</body>
</html>