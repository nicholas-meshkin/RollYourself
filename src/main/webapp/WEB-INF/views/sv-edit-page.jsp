<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateSV" method="post">
	<input type="hidden" name="id" value="${defaultSV.id}" />
		<p>
			<label id="title" for="title">Occupation Title:</label> <input value="${defaultSV.title}" class="inputbox" id="title" required
				name="title" pattern="[A-Za-z]*" />
		</p>
		<p>
			<label for="sv">Support Value:</label> <input value="${defaultSV.sv}" class="inputbox" id="sv" required
				name="sv"  pattern="[0-9]*" />
		</p>
	
		<p>
			<label for="townType">Town Type:</label> <select class="inputbox" id="townType"
				name="townType" >
			<option value="ActualCity">Actual City (uses default SVs)</option>
			<option value="RuralCommunity">Rural Community (uses modified SVs)</option>
			</select>
		</p>
		<p>
			<button>Submit</button>
		</p>
	</form>
</body>
</html>