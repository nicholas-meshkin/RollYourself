<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Character Sheet</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>

<div class="container">
<body>
<!-- Modal -->

<div class="modal fade" id="congrats" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Congratulations!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        You are a ${character.race} ${character.characterClass} named ${character.name}!!
      </div>
    </div>
  </div>
</div>
	<div class="row">
		<div class="col-4">
			<h3>Character Name: ${character.name}</h3>
		</div>
		<div class="col-6">
			<div class="row">
				<div class="col-6">
					<p>Class: ${character.characterClass}</p>
					<p> Race: <a href=" " title="${raceDetail.age} ${raceDetail.sizeDescription}">${character.race}</a></p>
				</div>
				<div class="col-6">
					<p>Alignment: ${alignment}</p><p> Experience Points: 0</p>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-4">
			<div class="bubble"><p class="value">${maxHp}</p><p class="label">Max HP</p></div>
			<div class="bubble"><p class="value">${abilityBonuses[1]}</p><p class="label">Initiative</p></div>
			<div class="bubble"><p class="value">${character.raceDetail.speed}</p><p class="label">Speed</p></div>
			<div class="bubble"><p class="value">1d${character.classDetail.hitDie}</p><p class="label">Hit Dice</p></div>
			<div class="bubble"><p class="value">2</p><p class="label">Proficiency Bonus</p></div>
			<div class="bubble"><p class="value">${aC}</p><p class="label">Armor Class</p></div>
			<div class="bubble"><p class="value">${passivePerception}</p><p class="label">Passive Perception</p></div>
		</div>
		<div class="col-6">
			<table class="table table-striped table-sm">
				<tr>
					<th>Ability</th><th>Score</th><th>Modifier</th>
				</tr>		
				<tr>
					<td><a href=" " title="${abilityScore1.desc}">Strength</a></td>
					<td>${character.strength}</td><td>${abilityBonuses[0]}</td>
				</tr>
				<tr>
					<td><a href=" " title="${abilityScore2.desc}">Dexterity</a></td>
					<td>${character.dexterity}</td><td>${abilityBonuses[1]}</td>
				</tr>
				<tr>		
					<td><a href=" " title="${abilityScore3.desc}">Constitution</a></td>
					<td>${character.constitution}</td><td>${abilityBonuses[2]}</td>
				</tr>
				<tr>		
					<td><a href=" " title="${abilityScore4.desc}">Intelligence</a></td>
					<td>${character.intelligence}</td><td>${abilityBonuses[3]}</td>
				</tr>
				<tr>		
					<td><a href=" " title="${abilityScore5.desc}">Wisdom</a></td>
					<td>${character.wisdom}</td><td>${abilityBonuses[4]}</td>
				</tr>
				<tr>		
					<td><a href=" " title="${abilityScore6.desc}">Charisma</a></td>
					<td>${character.charisma}</td><td>${abilityBonuses[5]}</td>
				</tr>	
			</table>
		</div>
	</div>
	
	<div class="row">
		<div class="col-4">
			<table class="table table-striped table-sm">
				<tr><th>Prof?</th><th>Skill</th><th>Bonus</th></tr>
				<c:set var="profNames" value="${profNames}"/>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Acrobatics\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill1.desc}">Acrobatics:</a></td><td>${skills[0]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Animal Handling\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill2.desc}">Animal Handling:</a></td><td>${skills[1]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Arcana\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill3.desc}">Arcana:</a></td><td>${skills[2]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Athletics\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill4.desc}">Athletics:</a></td><td>${skills[3]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Deception\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill5.desc}">Deception:</a></td><td>${skills[4]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"History\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill6.desc}">History:</a></td><td>${skills[5]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Insight\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill7.desc}">Insight:</a></td><td>${skills[6]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Intimidation\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill8.desc}">Intimidation:</a></td><td>${skills[7]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Investigation\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill9.desc}">Investigation:</a></td><td>${skills[8]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Medicine\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill10.desc}"> Medicine:</a></td><td>${skills[9]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Nature\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill11.desc}">Nature:</a></td><td>${skills[10]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Perception\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill12.desc}">Perception:</a></td><td>${skills[11]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Performance\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill13.desc}">Performance:</a></td><td>${skills[12]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Persuasion\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill14.desc}">Persuasion:</a></td><td>${skills[13]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Religion\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill15.desc}">Religion:</a></td><td>${skills[14]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Sleight of Hand\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill16.desc}">Sleight of Hand:</a></td><td>${skills[15]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Stealth\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill17.desc}">Stealth:</a></td><td>${skills[16]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(profNames,\"Survival\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href=" " title="${skill18.desc}">Survival:</a></td><td>${skills[17]}</td></tr>
			</table>
		</div>
		<div class="col-6">
		
		
		<div class="row">
		<div class="col-6">
			<table class="table table-striped table-sm">
				<tr><th>Saving Throws</th><th>Bonus</th></tr>
				<tr><td>STR:</td><td>${savingThrows[0]}</td></tr>
				<tr><td>DEX:</td><td>${savingThrows[1]}</td></tr>
				<tr><td>CON:</td><td>${savingThrows[2]}</td></tr>
				<tr><td>INT:</td><td>${savingThrows[3]}</td></tr>
				<tr><td>WIS:</td><td>${savingThrows[4]}</td></tr>
				<tr><td>CHA:</td><td>${savingThrows[5]}</td></tr>
			</table>
			
			</div>
			<div class="col-6">
			<table class="table table-striped table-sm">
						<tr><th>Proficiencies:</th></tr>
						<c:forEach var="prof" items="${character.classDetail.proficiencies}">
						<tr><td>${prof.name}</td></tr>
						</c:forEach>
						<c:forEach var="prof" items="${character.raceDetail.startingProficiencies}">
						<tr><td>${prof.name}</td></tr>
						</c:forEach>
					</table>
					</div>
			</div>
			
			<table class="table table-striped table-sm">
				<tr><th>Weapon</th><th>Range</th><th>Attack Bonus</th><th>Damage</th><th>Damage Type</th></tr>
				<c:forEach var="weapon" items="${weaponList}">
				<tr><td>${weapon.name}</td><td>${weapon.weaponRange}</td><td>${weapon.atkBonus}</td><td>${weapon.damage.diceCount}d${weapon.damage.diceValue} + ${weapon.dmgBonus}</td><td>${weapon.damage.damageTypeItem.name}</td></tr>
				</c:forEach>
			</table>
			<div class="row">
				<div class="col-7">
					<table class="table table-striped table-sm">
						<tr><th>Armor & Other Equipment</th></tr>
						<c:forEach var="armor" items="${armorList}">
						<tr><td>${armor.name} (armor)</td></tr>
						</c:forEach>
						<c:forEach var="item" items="${otherEquipmentList}">
						<tr><td>${item.name}</td></tr>
						</c:forEach>
					</table>
				</div>
				<div class="col-5">
					<table class="table table-striped table-sm">
						<tr><th>Traits:</th></tr>
						<c:forEach var="trait" items="${character.raceDetail.traits}">
						<tr><td>${trait.name}</td></tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<table class="table table-striped table-sm">
	<tr><th>
	<a href="/language-detail/${character.raceDetail.index}" title="${character.raceDetail.languageDescription}">Languages Spoken:</a>
	</th></tr>
	<c:forEach var="lang" items="${character.raceDetail.languages}">
	<tr><td>${lang.name}</td></tr>
	</c:forEach>
	</table>
		</div>
	</div>
	
	
	<div class="d-flex justify-content-center col-9"><h3>Spellcasting</h3></div>
	<div class="row">
		<div class="col-4">
	<table class="table table-striped table-sm">
		<tr><td><a href="" title="${spellcasting.info[3].desc}">Spellcasting Ability:</a> ${spellInfo.spellcastingAbility}</td></tr>
		<tr><td><p>Spell Attack Modifier: ${spellInfo.spellAttackModifier}</p></td></tr>
		<tr><td><p>Spell Save DC: ${spellInfo.spellSaveDc}</p></td></tr>
		<tr><td><a>Spell Slots: ${spellInfo.firstLevelSlots}</a></td></tr>
	</table>
	</div>
	<div class="col-3">
	<table class="table table-striped table-sm">
	<tr><th><a href="" title="${spellcasting.info[0].desc}">Cantrips Known:</a></th></tr>
	<c:forEach var="spell" items="${cantrips}">
	<tr><td><a href="/spell-detail/${spell.index}">${spell.name}</a></td></tr>
	</c:forEach>
	</table>
	</div>
	<div class="col-3">
	<table class="table table-striped table-sm">
	<tr><th><a href="" title="${spellcasting.info[1].desc}">First Level Spells Known:</a></th></tr>
	<c:forEach var="spell" items="${firstLevelSpells}">
	<tr><td><a href="/spell-detail/${spell.index}">${spell.name}</a></td></tr>
	</c:forEach>
	</table>
	</div>
	</div>
		
	<a href="/" class="btn btn-secondary mb-5" >Home</a>
	&nbsp; &nbsp; <!-- adds space between buttons -->
    <a href="/viewCharacterList" class="btn btn-secondary mb-5">Character List</a>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<c:if test="${newChar}"><script>$('#congrats').modal()</script></c:if>

</body>
</div>
</html>