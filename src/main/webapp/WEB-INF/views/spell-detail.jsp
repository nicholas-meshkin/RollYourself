<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spell Detail</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<div class="container">

<body>

<p>Name: ${spell.name}</p>
<p>Description:</p>
<c:forEach var="item" items="${spell.desc}"><p>${item}</p></c:forEach>
<p>Range: ${spell.range} </p>
<p>Components: ${spell.components}</p>
<p>Duration: ${spell.duration}</p>
<p>Casting Time: ${spell.castingTime}</p>
<p>School: ${spell.school.name}</p>
<p>Ritual: ${spell.ritual}</p>
<p>Concentration: ${spell.concentration}</p>
<p></p>
</body>

</div>
</html>