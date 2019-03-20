<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>character list</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

</head>
<div class="container">

<body  id="page">

<h1>Character List</h1>
		
	<table  class="table table-striped table-sm table-bordered" id="listtable">
	
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
						<form action="/displayCharacter"><input type="hidden" name="id" value="${character.id}" /><button type="submit" id="details">Details</button></form>   
				</td>
				
				<td>
						<form action="/deleteChar"><input type="hidden" name="id" value="${character.id}" /><button type="submit" onclick="return confirm('Are you sure?')" id="delete">Delete</button></form>   
				</td>

			</tr>
			
			</c:forEach>
		</tbody>
			
	</table>
			
			<a href="/" class="btn btn-secondary mb-5">home</a>

</body>
</div>
</html>