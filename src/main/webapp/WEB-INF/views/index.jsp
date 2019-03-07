<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<table>
<tr><th>Class</th><th>URL</th></tr>
<c:forEach var="classListItem" items="${classList}">
<tr><td>${classListItem.name}</td><td>${classListItem.url}</td></tr>
</c:forEach>

</table>
</body>
</html>