<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/city-generator-index">Home</a>
<form action="specEdit" method="post">
	<input type="hidden" name="id" />
		<p>
			<label for="name">Species Name:</label> <input class="inputbox" id="name" required
				name="name" pattern="[A-Za-z\-]*" />
		</p>
		<p>
			<label for="famAvg">Mean family size:</label> <input  class="inputbox" id="famAvg" required
				name="famAvg"  pattern="[0-9]*" />
		</p>
	<p>
			<label for="famStDev">Family size standard deviation:</label> <input  class="inputbox" id="famStDev" required
				name="famStDev"  pattern="[0-9]*" />
		</p>
		<p>
			<label for="ageMean">Mean age:</label> <input  class="inputbox" id="ageMean" required
				name="ageMean"  pattern="[0-9]*" />
		</p>
		<p>
			<label for="ageStDev">Age standard deviation:</label> <input  class="inputbox" id="ageStDev" required
				name="ageStDev"  pattern="[0-9]*" />
		</p>
		<p>
			<label for="fertAge">Age of Adulthood:</label> <input  class="inputbox" id="fertAge" required
				name="fertAge"  pattern="[0-9]*" />
		</p>
		<p>
			<label for="popPct">Percentage of Population:</label> <input  class="inputbox" id="popPct" required
				name="popPct"  pattern="[0-9]*" />
		</p>
		<p>
			<button>Submit</button>
		</p>
	</form>
	<table>
	<tr><th>Name</th><th>Mean Fam Size</th><th>Fam StDev</th><th>Age Mean</th><th>Age StDev</th><th>Adulthood Age</th><th>Population Pct</th></tr>
	<c:forEach items="${specList}" var="thing">
		<tr><td>${thing.name}</td>
			<td>${thing.famAvg}</td>
			<td>${thing.famStDev}</td>
			<td>${thing.ageMean}</td>
			<td>${thing.ageStDev}</td>
			<td>${thing.fertAge}</td>
			<td>${thing.popPct}</td>
			<td><form action="/deleteSpecies"><input type="hidden" name="id" value="${thing.id}" /><button type="submit" id="delete">Delete</button></form></td>
			<td><form action="/updateSpecies"><input type="hidden" name="id" value="${thing.id}" /><button type="submit" id="update">Update</button></form></td>
		
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>