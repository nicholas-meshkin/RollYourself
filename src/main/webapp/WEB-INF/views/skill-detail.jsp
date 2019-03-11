<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<div class="container">
<body>
<p>Skill: ${skill.name}</p>
<p>Description:</p>
<c:forEach var="thing" items="${skill.desc }">
<p> ${thing}</p>
</c:forEach>
<p>Governing Ability: ${skill.abilityScore.name}</p>
</body>
</div>
</html>