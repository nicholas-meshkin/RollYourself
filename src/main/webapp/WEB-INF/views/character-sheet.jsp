<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Character Sheet</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<div class="container">
<body>
	<h1>Character</h1>
	<p>Class: ${character.characterClass} &nbsp Race: <a href=" " title="${raceDetail.age} ${raceDetail.sizeDescription}">${character.race}</a> <!--&nbsp Subrace: ${character.subraceDetail.name}--> &nbsp Character Name: ${character.name}</p>
	<p>Alignment: ${alignment}</p>
	<p>Max HP: ${maxHp}</p>
	<p>Initiative: ${abilityBonuses[1]}</p>
	<p>Speed: ${character.raceDetail.speed}</p>
	<p>Hit Dice: 1d${character.classDetail.hitDie}</p>
	<p>Proficiency Bonus: 2</p>
	<table class="table table-striped">
		<tr>
			<th>Ability</th><th>Score</th><th>Modifier</th>
		</tr>		
		<tr>
			<td><a href=" " title="${abilityScore1.desc}">Strength</a></td><td>${character.strength}</td><td>${abilityBonuses[0]}</td>
		</tr>
		<tr>
				<td><a href=" " title="${abilityScore2.desc}">Dexterity</a></td><td>${character.dexterity}</td><td>${abilityBonuses[1]}</td>
		</tr>
		<tr>		
				<td><a href=" " title="${abilityScore3.desc}">Constitution</a></td><td>${character.constitution}</td><td>${abilityBonuses[2]}</td>
		</tr>
		<tr>		
				<td><a href=" " title="${abilityScore4.desc}">Intelligence</a></td><td>${character.intelligence}</td><td>${abilityBonuses[3]}</td>
		</tr>
		<tr>		
				<td><a href=" " title="${abilityScore5.desc}">Wisdom</a></td><td>${character.wisdom}</td><td>${abilityBonuses[4]}</td>
		</tr>
		<tr>		
				<td><a href=" " title="${abilityScore6.desc}">Charisma</a></td><td>${character.charisma}</td><td>${abilityBonuses[5]}</td>
		</tr>	
	</table>
	
	<table class="table table-striped">
	<tr><th>Saving Throws</th><th>Bonus</th></tr>
	<tr><td>STR:</td><td>${savingThrows[0]}</td></tr>
	<tr><td>DEX:</td><td>${savingThrows[1]}</td></tr>
	<tr><td>CON:</td><td>${savingThrows[2]}</td></tr>
	<tr><td>INT:</td><td>${savingThrows[3]}</td></tr>
	<tr><td>WIS:</td><td>${savingThrows[4]}</td></tr>
	<tr><td>CHA:</td><td>${savingThrows[5]}</td></tr>
	</table>
	
	<table class="table table-striped">
	<tr><th>Skill</th><th>Bonus</th></tr>
	<tr><td><a href=" " title="${skill1.desc}">Acrobatics:</a></td><td>${skills[0]}</td></tr>
	<tr><td><a href=" " title="${skill2.desc}">Animal Handling:</a></td><td>${skills[1]}</td></tr>
	<tr><td><a href=" " title="${skill3.desc}">Arcana:</a></td><td>${skills[2]}</td></tr>
	<tr><td><a href=" " title="${skill4.desc}">Athletics:</a></td><td>${skills[3]}</td></tr>
	<tr><td><a href=" " title="${skill5.desc}">Deception:</a></td><td>${skills[4]}</td></tr>
	<tr><td><a href=" " title="${skill6.desc}">History:</a></td><td>${skills[5]}</td></tr>
	<tr><td><a href=" " title="${skill7.desc}">Insight:</a></td><td>${skills[6]}</td></tr>
	<tr><td><a href=" " title="${skill8.desc}">Intimidation:</a></td><td>${skills[7]}</td></tr>
	<tr><td><a href=" " title="${skill9.desc}">Investigation:</a></td><td>${skills[8]}</td></tr>
	<tr><td><a href=" " title="${skill10.desc}"> Medicine:</a></td><td>${skills[9]}</td></tr>
	<tr><td><a href=" " title="${skill11.desc}">Nature:</a></td><td>${skills[10]}</td></tr>
	<tr><td><a href=" " title="${skill12.desc}">Perception:</a></td><td>${skills[11]}</td></tr>
	<tr><td><a href=" " title="${skill13.desc}">Performance:</a></td><td>${skills[12]}</td></tr>
	<tr><td><a href=" " title="${skill14.desc}">Persuasion:</a></td><td>${skills[13]}</td></tr>
	<tr><td><a href=" " title="${skill15.desc}">Religion:</a></td><td>${skills[14]}</td></tr>
	<tr><td><a href=" " title="${skill16.desc}">Sleight of Hand:</a></td><td>${skills[15]}</td></tr>
	<tr><td><a href=" " title="${skill17.desc}">Stealth:</a></td><td>${skills[16]}</td></tr>
	<tr><td><a href=" " title="${skill18.desc}">Survival:</a></td><td>${skills[17]}</td></tr>
	</table>
	
	<table class="table table-striped">
	<tr><th>Weapon</th><th>Range</th><th>Attack Bonus</th><th>Damage</th><th>Damage Type</th></tr>
	<c:forEach var="weapon" items="${weaponList}">
	<tr><td>${weapon.name}</td><td>${weapon.weaponRange}</td><td>${weapon.atkBonus}</td><td>${weapon.damage.diceCount}d${weapon.damage.diceValue} + ${weapon.dmgBonus}</td><td>${weapon.damage.damageTypeItem.name}</td></tr>
	</c:forEach>
	</table>
	
	<p>Armor Class: ${aC}</p>
	
	<div>
	<h3>Armor & Other Equipment</h3>
	<c:forEach var="armor" items="${armorList}">
	<p>${armor.name}</p>
	</c:forEach>
	<c:forEach var="item" items="${otherEquipmentList}">
	<p>${item.name}</p>
	</c:forEach>
	</div>

	
	<p>Passive Perception: ${passivePerception}</p>
	<p>Proficiencies:</p><ul><c:forEach var="prof" items="${character.classDetail.proficiencies}"><li>${prof.name}</li></c:forEach></ul>
	<p>Traits:</p><ul><c:forEach var="trait" items="${character.raceDetail.traits}"><li>${trait.name}</li></c:forEach></ul>
	<p><a href="/language-detail/${character.raceDetail.index}">Languages Spoken:</a></p><ul><c:forEach var="lang" items="${character.raceDetail.languages}"><li>${lang.name}</li></c:forEach></ul>
	<!-- TODO add only non-skill proficiencies from race -->
	<!--
	<p>Cantrips Known:</p><ul><c:forEach var="spell" items="${cantrips}"><li><a href="/spell-detail/${spell.index}">${spell.name}</a></li></c:forEach></ul>
	<p>First Level Spells Known:</p><ul><c:forEach var="spell" items="${firstLevelSpells}"><li><a href="/spell-detail/${spell.index}">${spell.name}</a></li></c:forEach></ul>
	<p>Spell Slots: ${spellInfo.firstLevelSlots}</p>
	<p>Spellcasting Ability: ${spellInfo.spellcastingAbility}</p>
	<p>Spell Attack Modifier: ${spellInfo.spellAttackModifier}</p>
	<p>Spell Save DC: ${spellInfo.spellSaveDc}</p>
	<c:forEach var="item" items="${spellcasting.info}">
	<p>${item.desc}</p>
	</c:forEach> -->
	<a href="/">Home</a>
</body>
</div>
</html>