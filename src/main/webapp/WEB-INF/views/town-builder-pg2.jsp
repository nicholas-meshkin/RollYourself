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
<a href="/">Home</a>

<form action="townBuilder3">
<input type="hidden" name="size" value="${size}"/>
<input type="hidden" name="svType" value="${svType}"/>
<table>
<tr><th>Species</th><th>PCT of Population</th><th>Culture for names</th></tr>
<c:forEach var="species" items="${specList}">
	<tr>
	<td><input type="hidden" name="specIds" value="${species.id}">${species.name}</td>
	<td> <input name="popList" class="inputbox" required  pattern="[0-9]*" /></td>
	<td>
		<select name="cultureList">
			<c:forEach var="culture" items="${cultureList}">
			 <option value = "${culture.id}">${culture.culture}</option>
			</c:forEach>
		</select>
	</td>
	</tr>
</c:forEach>
</table>
<p><button>Submit</button></p>
</form>

</body>
</html>