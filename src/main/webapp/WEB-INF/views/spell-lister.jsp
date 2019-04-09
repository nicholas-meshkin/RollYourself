<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form action="/spellPage">
		<div class="row">
			<div class="col-6">
				<div>
				Select a class
				<select class="selections1" name="charClass" >
				<option value = "1"></option>
				<option value="1"> Barbarian</option>
				<option value="2">Bard</option>
				<option value="3">Cleric</option>
				<option value="4">Druid</option>
				<option value="5">Fighter</option>
				<option value="6">Monk</option>
				<option value="7">Paladin</option>
				<option value="8">Ranger</option>
				<option value="9">Rogue</option>
				<option value="10">Sorcerer</option>
				<option value="11">Warlock</option>
				<option value="12">Wizard</option>
				</select>
				</div>
				
				<div>
				Select a Spell Level
				<select class="selections1" name="level" >
				<option value = "1"></option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				</select>
				</div>
				
				
				<div>
				<button type="submit" class="btn btn-info" value="Submit">Submit</button>
				</div>
			</div>
		</div>
	</form>

</div>
</body>
</html>