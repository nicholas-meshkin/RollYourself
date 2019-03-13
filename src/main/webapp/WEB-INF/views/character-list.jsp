<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>character list</title>
</head>
<body>

	<div class="container">

<h1>Character List</h1>
		
	<table  class="table table-striped">
	
  			<col>
  			<col>
  			<col>
  			<colgroup span="2"></colgroup>
			<thead class="thead-dark">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Race</th>
					<th scope="col">Class</th>
					<th colspan="2" scope="colgroup"></th>
				</tr>
			</thead>
		
		<tbody>
			<c:forEach var="character" items="${characterlist}">
			
			<tr>
				<td>${character.name}</td>
				<td>${character.race}</td>
				<td>${character.characterClass}</td>	
				
				<td>
						<form action="/displayCharacter"><input type="hidden" name="id" value="${character.id}" /><button type="submit">Details</button></form>   
				</td>
			</tr>
			
			</c:forEach>
		</tbody>
			
	</table>
			
		<ul>		
			<a href="/" class="btn btn-secondary ml-3">home</a>
		</ul>

	</div>

</body>
</html>