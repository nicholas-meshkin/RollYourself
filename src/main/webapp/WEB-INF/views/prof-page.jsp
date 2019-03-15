<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
<table class="table table-striped">
<tr><th>Class</th><th>NumChoices</th><th>ChoiceList</th></tr>
<c:forEach var="item" items="${classList }">
<tr>
<td>${item.name}</td><td>${item.proficiencyChoices[0].choose}</td><td><ul><c:forEach var="thing" items="${item.proficiencyChoices[0].from}"><li>${thing.name}</li></c:forEach></ul></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>