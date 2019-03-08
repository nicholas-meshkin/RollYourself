<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Character</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<div class="container">
<body>
	<h1>Character</h1>
	<p>Class: ${classDetail.name} &nbsp Race: ${raceDetail.name}</p>
	<table class="table table-striped">
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
</div>
</html>