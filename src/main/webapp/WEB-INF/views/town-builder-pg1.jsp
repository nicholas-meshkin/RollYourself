<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="townBuilder2">
		<p>
		Town Size:<input class="inputbox" id="size" required
				name="size"  pattern="[0-9]*" />
		</p>
		<p>
			Town Type:<select class="inputbox" id="svType"
				name="svType" >
			<option value="ActualCity">Actual City (uses default SVs)</option>
			<option value="RuralCommunity">Rural Community (uses modified SVs)</option>
			</select>
		</p>
		<c:forEach var="spec" items="${specList}">
		<p>${spec.name}<input type="checkbox" name="specIds" value="${spec.id}"/></p>
		</c:forEach>
		<p>
			<button>Submit</button>
		</p>
</form>
<a href="/">Home</a>
</body>
</html>