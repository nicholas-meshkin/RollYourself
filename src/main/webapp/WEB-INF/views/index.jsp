<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<a href="/character">Character Sheet</a>
<p></p>
<a href="/questionnaire">Take our questionnaire to create your personal D&D avatar.</a>
</head>
<body>
<div class="container">
<table class="table table-striped">

<tr><th>Class</th><th>URL</th></tr>
<c:forEach var="classListItem" items="${classList}">
<tr><td>${classListItem.name}</td><td>${classListItem.url}</td></tr>
</c:forEach>

</table>
</div>
</body>
</html>