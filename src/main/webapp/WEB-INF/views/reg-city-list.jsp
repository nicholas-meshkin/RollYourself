<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<div class="container">
<a href="/city-generator-index">Home</a>
	<table>
	<tr><th>Title</th><th>SV</th><th>Type</th><th>Family Profession?</th></tr>
	<c:forEach items="${list}" var="thing">
		<tr><td>${thing.title}</td>
			<td>${thing.sv}</td>
			<td>${thing.townType}</td>
			<td><c:choose><c:when test="${thing.famjob}">Yes</c:when><c:otherwise>No</c:otherwise></c:choose></td>
			<td><form action="/deleteSV"><input type="hidden" name="id" value="${thing.id}" /><button type="submit" id="delete">Delete</button></form></td>
			<td><form action="/updateSV"><input type="hidden" name="id" value="${thing.id}" /><button type="submit" id="update">Update</button></form></td>
		
		</tr>
	</c:forEach>
	</table>
	
	</div>
</html>