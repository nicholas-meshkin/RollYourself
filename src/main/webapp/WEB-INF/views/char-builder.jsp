<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Character Builder</title>
</head>
<body>

<div class="container">
	<form action="/buildChar">
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
				Select a class
				<select class="selections1" name="charRace" >
				<option value = "1"></option>
				<option value="1">Dwarf</option>
				<option value="2">Elf</option>
				<option value="3">Halfling</option>
				<option value="4">Human</option>
				<option value="5">Dragonborn</option>
				<option value="6">Gnome</option>
				<option value="7">Half-Elf</option>
				<option value="8">Half-Orc</option>
				<option value="9">Tiefling</option>
				</select>
				</div>
				
				<div>
				Select an alignment
				<select class="selections1" name="charAlign" >
				<option value = "1"></option>
				<option value="1">Lawful Good</option>
				<option value="2">Neutral Good</option>
				<option value="3">Chaotic Good</option>
				<option value="4">Lawful Neutral</option>
				<option value="5">True Neutral</option>
				<option value="6">Chaotic Neutral</option>
				<option value="7">Lawful Evil</option>
				<option value="8">Neutral Evil</option>
				<option value="9">Chaotic Evil</option>
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