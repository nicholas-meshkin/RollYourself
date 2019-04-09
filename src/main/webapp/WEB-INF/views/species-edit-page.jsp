<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateSpecies" method="post">
	<input type="hidden" name="id" value="${species.id}" />
		<p>
			<label for="name">Species Name:</label> <input value="${species.name}" class="inputbox" id="name" required
				name="name" pattern="[A-Za-z\-]*" />
		</p>
		<p>
			<label for="famAvg">Mean family size:</label> <input value="${species.famAvg}" class="inputbox" id="famAvg" required
				name="famAvg"  pattern="[0-9]*" />
		</p>
	<p>
			<label for="famStDev">Family size standard deviation:</label> <input value="${species.famStDev}" class="inputbox" id="famStDev" required
				name="famStDev"  pattern="[0-9]*" />
		</p>
		<p>
			<label for="ageMean">Mean age:</label> <input value="${species.ageMean}" class="inputbox" id="ageMean" required
				name="ageMean"  pattern="[0-9]*" />
		</p>
		<p>
			<label for="ageStDev">Age standard deviation:</label> <input value="${species.ageStDev}" class="inputbox" id="ageStDev" required
				name="ageStDev"  pattern="[0-9]*" />
		</p>
		<p>
			<label for="fertAge">Age of Adulthood:</label> <input value="${species.fertAge}" class="inputbox" id="fertAge" required
				name="fertAge"  pattern="[0-9]*" />
		</p>
		<p>
			<label for="popPct">Percentage of Population:</label> <input value="${species.popPct}" class="inputbox" id="popPct" required
				name="popPct"  pattern="[0-9]*" />
		</p>
		<p>
			<button>Submit</button>
		</p>
	</form>
</body>
</html>