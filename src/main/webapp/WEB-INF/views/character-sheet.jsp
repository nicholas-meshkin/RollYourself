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
	<p>Class: ${character.characterClass} &nbsp Race: <a href="/race-details/${character.raceDetail.index}">${character.race}</a> &nbsp Subrace: ${character.subraceDetail.name} &nbsp Player Name: ${character.name}</p>
	<table class="table table-striped">
		<tr>
			<th>Characteristics</th><th>Statistics</th>
		</tr>		
		<tr>
			<td><a href="/ability-detail/1">${character.characteristicSTR}</a></td><td>${character.strength}</td>
		</tr>
		<tr>
				<td><a href="/ability-detail/2">${character.characteristicDEX}</a></td><td>${character.dexterity}</td>
		</tr>
		<tr>		
				<td><a href="/ability-detail/3">${character.characteristicCON}</a></td><td>${character.constitution}</td>
		</tr>
		<tr>		
				<td><a href="/ability-detail/4">${character.characteristicINT}</a></td><td>${character.intelligence}</td>
		</tr>
		<tr>		
				<td><a href="/ability-detail/5">${character.characteristicWIS}</a></td><td>${character.wisdom}</td>
		</tr>
		<tr>		
				<td><a href="/ability-detail/6">${character.characteristicCHA}</a></td><td>${character.charisma}</td>
		</tr>	
	</table>
	
	<table>
	<tr><th>Saving Throws</th></tr>
	<tr><td>STR:</td><td>${savingThrows[0]}</td></tr>
	<tr><td>DEX:</td><td>${savingThrows[1]}</td></tr>
	<tr><td>CON:</td><td>${savingThrows[2]}</td></tr>
	<tr><td>INT:</td><td>${savingThrows[3]}</td></tr>
	<tr><td>WIS:</td><td>${savingThrows[4]}</td></tr>
	<tr><td>CHA:</td><td>${savingThrows[5]}</td></tr>
	</table>
	
	<table>
	<tr><th>Skill</th><th>Bonus</th></tr>
	<tr><td><a href="/skill-detail/1">Acrobatics:</a></td><td>${skills[0]}</td></tr>
	<tr><td><a href="/skill-detail/2">Animal Handling:</a></td><td>${skills[1]}</td></tr>
	<tr><td><a href="/skill-detail/3">Arcana:</a></td><td>${skills[2]}</td></tr>
	<tr><td><a href="/skill-detail/4">Athletics:</a></td><td>${skills[3]}</td></tr>
	<tr><td><a href="/skill-detail/5">Deception:</a></td><td>${skills[4]}</td></tr>
	<tr><td><a href="/skill-detail/6">History:</a></td><td>${skills[5]}</td></tr>
	<tr><td><a href="/skill-detail/7">Insight:</a></td><td>${skills[6]}</td></tr>
	<tr><td><a href="/skill-detail/8">Intimidation:</a></td><td>${skills[7]}</td></tr>
	<tr><td><a href="/skill-detail/9">Investigation:</a></td><td>${skills[8]}</td></tr>
	<tr><td><a href="/skill-detail/10"> Medicine:</a></td><td>${skills[9]}</td></tr>
	<tr><td><a href="/skill-detail/11">Nature:</a></td><td>${skills[10]}</td></tr>
	<tr><td><a href="/skill-detail/12">Perception:</a></td><td>${skills[11]}</td></tr>
	<tr><td><a href="/skill-detail/13">Performance:</a></td><td>${skills[12]}</td></tr>
	<tr><td><a href="/skill-detail/14">Persuasion:</a></td><td>${skills[13]}</td></tr>
	<tr><td><a href="/skill-detail/15">Religion:</a></td><td>${skills[14]}</td></tr>
	<tr><td><a href="/skill-detail/16">Sleight of Hand:</a></td><td>${skills[15]}</td></tr>
	<tr><td><a href="/skill-detail/17">Stealth:</a></td><td>${skills[16]}</td></tr>
	<tr><td><a href="/skill-detail/18">Survival:</a></td><td>${skills[17]}</td></tr>
	</table>
	
	
	
	<p>Max HP: ${maxHp}</p>
	<p>Hit Dice: 1d${character.classDetail.hitDie}</p>
	<p>Proficiency Bonus: 2</p>
	<p>Passive Perception: ${passivePerception}</p>
	<p>Proficiencies:</p><ul><c:forEach var="prof" items="${character.classDetail.proficiencies}"><li>${prof.name}</li></c:forEach></ul>
	<!-- TODO add only non-skill proficiencies from race -->
</body>
</div>
</html>