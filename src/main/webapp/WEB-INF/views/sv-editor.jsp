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
<a href="/reg-city-list">List for large city</a>
<a href="/rural-city-list">List for rural community</a>
	<form action="sv-editor" method="post">
		<p>
			<label id="title" for="title">Occupation Title:</label> <input class="inputbox" id="title" required
				name="title" pattern="[A-Za-z]*" />
		</p>
		<p>
			<label for="sv">Support Value:</label> <input class="inputbox" id="sv" required
				name="sv"  pattern="[0-9]*" />
		</p>
	
		<p>
			<label for="townType">Town Type:</label> <select class="inputbox" id="townType"
				name="townType">
			<option value="ActualCity">Actual City (uses default SVs)</option>
			<option value="RuralCommunity">Rural Community (uses modified SVs)</option>
			</select>
		</p>
		<p>
			<label for="famjob">Family Profession?</label> <select class="inputbox" id="famjob"
				name="famjob">
			<option value="true">Yes</option>
			<option value="false">No</option>
			</select>
		</p>
		<p>
			<button>Submit</button>
		</p>
	</form>
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