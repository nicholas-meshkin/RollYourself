<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Character</title>
</head>
<body>
	<h1>Character</h1>
	<table>
		<tr>
			<th>Statistics</th>
		</tr>
		<c:forEach var="s" items="${stat}">
			<tr>
				<td>${s}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>