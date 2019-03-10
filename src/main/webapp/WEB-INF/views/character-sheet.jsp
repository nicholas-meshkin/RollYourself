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
	<p>Class: ${character.characterClass} &nbsp Race: ${character.race} &nbsp Player Name: ${character.name}</p>
	<table class="table table-striped">
		<tr>
			<th>Characteristics</th><th>Statistics</th>
		</tr>		
		<tr>
			<td>${character.characteristicSTR}</td><td>${character.strength}</td>
		</tr>
		<tr>
				<td>${character.characteristicDEX}</td><td>${character.dexterity}</td>
		</tr>
		<tr>		
				<td>${character.characteristicCON}</td><td>${character.constitution}</td>
		</tr>
		<tr>		
				<td>${character.characteristicINT}</td><td>${character.intelligence}</td>
		</tr>
		<tr>		
				<td>${character.characteristicWIS}</td><td>${character.wisdom}</td>
		</tr>
		<tr>		
				<td>${character.characteristicCHA}</td><td>${character.charisma}</td>
		</tr>	
	</table>
</body>
</div>
</html>