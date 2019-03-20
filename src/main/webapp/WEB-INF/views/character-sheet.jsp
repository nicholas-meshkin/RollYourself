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

<div class="container" id="charCont">
<br><br>
<body class="charBody">

<div class="modal fade" id="congrats" tabindex="-1" role="dialog" aria-labelledby="congratsLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="congratsLabel">Congratulations!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <p>You are a ${character.race} ${character.characterClass} named ${character.name}!!</p> 
       <p>Click on any highlighted item to get a pop-up with more details</p>  
      </div>
    </div>
  </div>
</div>
	<div class="row">
	<div class="col-1"></div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<h3>Character Name: ${character.name}</h3>

	</div>
	<div class="row">
	<div class="col-1"></div>
		<div class="col-4">
			<div class="bubble"><p class="value">${maxHp}</p><p class="label">Max HP</p></div>
			<div class="bubble"><p class="value">${abilityBonuses[1]}</p><p class="label">Initiative</p></div>
			<div class="bubble"><p class="value">${character.raceDetail.speed}</p><p class="label">Speed</p></div>
			<div class="bubble"><p class="value">1d${character.classDetail.hitDie}</p><p class="label">Hit Dice</p></div>
			<div class="bubble"><p class="value">2</p><p class="label">Proficiency Bonus</p></div>
			<div class="bubble"><p class="value">${aC}</p><p class="label">Armor Class</p></div>
			<div class="bubble"><p class="value">${passivePerception}</p><p class="label">Passive Perception</p></div>
			<p></p>
		</div>
		<div class="col-6">
		<div class="row">
			
				<div class="col-6">
					<p>Class: ${character.characterClass}</p>
					<p><a href="#" data-toggle="modal" data-target="#modalRace">Race: ${character.race}</a></p>
							<div class="modal fade" id="modalRace" tabindex="-1" role="dialog" aria-labelledby="raceLabel" aria-hidden="true">
					  				<div class="modal-dialog" role="document">
					   					 <div class="modal-content">
					     					 <div class="modal-header">
					       						 <h5 class="modal-title" id="raceLabel">Race</h5>
					        						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					         						 <span aria-hidden="true">&times;</span>
					        						</button>
					      					</div>
					     				 	<div class="modal-body">
					       					<p>${raceDetail.age}</p><p> ${raceDetail.sizeDescription}</p>
					      					</div>
					    				</div>
					  				</div>
								</div>
				</div>
				<div class="col-6">
					<p>Alignment: ${alignment}</p><p> Experience Points: 0</p>
				</div>
				
			</div>
			<table id="charTable" class="table table-striped table-sm ">
				<tr>
					<th>Ability</th><th>Score</th><th>Modifier</th>
				</tr>		
						<c:forEach var="entry" items="${abMaster}">
							<div class="modal fade" id="modalAb${entry.key.name}" tabindex="-1" role="dialog" aria-labelledby="abLabel" aria-hidden="true">
				  				<div class="modal-dialog" role="document">
				   					 <div class="modal-content">
				     					 <div class="modal-header">
				       						 <h5 class="modal-title" id="abLabel">${entry.key.name }</h5>
				        						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				         						 <span aria-hidden="true">&times;</span>
				        						</button>
				      					</div>
				     				 	<div class="modal-body">
				       					<c:forEach var="item" items="${entry.key.desc}"><p>${item}</p></c:forEach>
				      					</div>
				    				</div>
				  				</div>
							</div>
							
							<tr><td><a href="#" data-toggle="modal" data-target="#modalAb${entry.key.name}">${entry.key.fullName}</a></td><td>${entry.value.score}</td><td>${entry.value.bonus}</td></tr>
						</c:forEach>
			</table>
		</div>
	</div>
	
	<div class="row">
	<div class="col-1"></div>
		<div class="col-4">
			<table id="charTable" class="table table-striped table-sm">
				<tr><th></th><th>Skill</th><th>Bonus</th></tr>
				<c:set var="profNames" value="${profNames}"/>
			<c:forEach var="entry" items="${skillMaster}">
			
			<div class="modal fade" id="modalSkill${entry.key.index}" tabindex="-1" role="dialog" aria-labelledby="skillLabel" aria-hidden="true">
  				<div class="modal-dialog" role="document">
   					 <div class="modal-content">
     					 <div class="modal-header">
       						 <h5 class="modal-title" id="skillLabel">${entry.key.name }</h5>
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
         						 <span aria-hidden="true">&times;</span>
        						</button>
      					</div>
     				 	<div class="modal-body">
       					<c:forEach var="item" items="${entry.key.desc}"><p>${item}</p></c:forEach>
      					</div>
    				</div>
  				</div>
			</div>
			
			<tr><td><c:choose><c:when test="${fn:contains(profNames,entry.key.name)}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td><a href="#" data-toggle="modal" data-target="#modalSkill${entry.key.index}">${entry.key.name}</a></td><td>${entry.value}</td></tr>
			</c:forEach>
			</table>
			
		</div>
		<div class="col-6">
		
		
		<div class="row">
		<div class="col-6">
			<table id="charTable" class="table table-striped table-sm">
				<tr><th></th><th>Saving Throws</th><th>Bonus</th></tr>
				<tr><td><c:choose><c:when test="${fn:contains(stNames,\"STR\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td>STR:</td><td>${savingThrows[0]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(stNames,\"DEX\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td>DEX:</td><td>${savingThrows[1]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(stNames,\"CON\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td>CON:</td><td>${savingThrows[2]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(stNames,\"INT\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td>INT:</td><td>${savingThrows[3]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(stNames,\"WIS\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td>WIS:</td><td>${savingThrows[4]}</td></tr>
				<tr><td><c:choose><c:when test="${fn:contains(stNames,\"CHA\")}">&#9679;</c:when><c:otherwise>&#9675;</c:otherwise></c:choose></td><td>CHA:</td><td>${savingThrows[5]}</td></tr>
			</table>
			
			</div>
			<div class="col-6">
			<table id="charTable" class="table table-striped table-sm">
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
			
			<table id="charTable" class="table table-striped table-sm">
				<tr><th>Weapon</th><th>Range</th><th>Attack Bonus</th><th>Damage</th><th>Damage Type</th></tr>
				<c:forEach var="weapon" items="${weaponList}">
				<tr><td>${weapon.name}</td><td>${weapon.weaponRange}</td><td>+ ${weapon.atkBonus}</td><td>${weapon.damage.diceCount}d${weapon.damage.diceValue} + ${weapon.dmgBonus}</td><td>${weapon.damage.damageTypeItem.name}</td></tr>
				</c:forEach>
			</table>
			<div class="row">
				<div class="col-7">
					<table id="charTable" class="table table-striped table-sm">
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
					<table id="charTable" class="table table-striped table-sm">
						<tr><th>Traits:</th></tr>
						<c:forEach var="trait" items="${character.raceDetail.traits}">
						<tr><td>${trait.name}</td></tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<table id="charTable" class="table table-striped table-sm">
				<tr><th>
				<a href="#" data-toggle="modal" data-target="#modalLang">Languages Spoken:</a>
					<div class="modal fade" id="modalLang" tabindex="-1" role="dialog" aria-labelledby="langLabel" aria-hidden="true">
			  				<div class="modal-dialog" role="document">
			   					 <div class="modal-content">
			     					 <div class="modal-header">
			       						 <h5 class="modal-title" id="langLabel">Language</h5>
			        						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			         						 <span aria-hidden="true">&times;</span>
			        						</button>
      					</div>
     				 	<div class="modal-body">
       					<p>${character.raceDetail.languageDescription}</p>
      					</div>
    				</div>
  				</div>
			</div>
	</th></tr>
	<c:forEach var="lang" items="${character.raceDetail.languages}">
	<tr><td>${lang.name}</td></tr>
	</c:forEach>
	</table>
		</div>
	</div>
	
	
	<div class="row">
		<div class= "col-5"></div><h3>Spellcasting</h3>
	</div>
	<div class="row">
	<div class="col-1"></div>
		<div class="col-4">
	<table id="charTable" class="table table-striped table-sm">
		<tr><th><a href="#" data-toggle="modal" data-target="#modalCastAB">Spellcasting Ability: </a>${spellInfo.spellcastingAbility}
		<div class="modal fade" id="modalCastAB" tabindex="-1" role="dialog" aria-labelledby="castABLabel" aria-hidden="true">
  				<div class="modal-dialog" role="document">
   					 <div class="modal-content">
     					 <div class="modal-header">
       						 <h5 class="modal-title" id="castABLabel">Spellcasting Ability</h5>
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
         						 <span aria-hidden="true">&times;</span>
        						</button>
      					</div>
     				 	<div class="modal-body">
     				 	<c:forEach items="${spellcasting.info[3].desc}" var="thing">
       					<p>${thing}</p>
       					</c:forEach>
      					</div>
    				</div>
  				</div>
			</div>
		</th></tr>
		<tr><td><p>Spell Attack Modifier: ${spellInfo.spellAttackModifier}</p></td></tr>
		<tr><td><p>Spell Save DC: ${spellInfo.spellSaveDc}</p></td></tr>
		<tr><td><a href="#" data-toggle="modal" data-target="#modalSlots">Spell Slots: </a>${spellInfo.firstLevelSlots}
		<div class="modal fade" id="modalSlots" tabindex="-1" role="dialog" aria-labelledby="slotsLabel" aria-hidden="true">
  				<div class="modal-dialog" role="document">
   					 <div class="modal-content">
     					 <div class="modal-header">
       						 <h5 class="modal-title" id="slotsLabel">Spell Slots</h5>
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
         						 <span aria-hidden="true">&times;</span>
        						</button>
      					</div>
     				 	<div class="modal-body">
     				 	<c:forEach items="${spellcasting.info[1].desc}" var="thing">
       					<p>${thing}</p>
       					</c:forEach>
      					</div>
    				</div>
  				</div>
			</div>
			</td></tr>
	</table>
	</div>
	
	<div class="col-3">
			<table id="charTable" class="table table-striped table-sm">
				<tr><th><a href="#" data-toggle="modal" data-target="#modalCants">Cantrips Known:</a>
				<div class="modal fade" id="modalCants" tabindex="-1" role="dialog" aria-labelledby="cantsLabel" aria-hidden="true">
		  				<div class="modal-dialog" role="document">
		   					 <div class="modal-content">
		     					 <div class="modal-header">
		       						 <h5 class="modal-title" id="cantsLabel">Cantrips</h5>
		        						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		         						 <span aria-hidden="true">&times;</span>
		        						</button>
		      					</div>
		     				 	<div class="modal-body">
		     				 	<c:forEach items="${spellcasting.info[0].desc}" var="thing">
		       					<p>${thing}</p>
		       					</c:forEach>
		      					</div>
		    				</div>
		  				</div>
					</div>
					</th></tr>
				
		
			<c:forEach var="spell" items="${cantrips}">
						<div class="modal fade" id="modalSpell${spell.index}" tabindex="-1" role="dialog" aria-labelledby="spellLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">${spell.name }</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					       	<c:forEach var="item" items="${spell.desc}"><p>${item}</p></c:forEach>
					      	<p>Range: ${spell.range} </p>
							<p>Components: ${spell.components}</p>
							<p>Duration: ${spell.duration}</p>
							<p>Casting Time: ${spell.castingTime}</p>
							<p>School: ${spell.school.name}</p>
							<p>Ritual: ${spell.ritual}</p>
							<p>Concentration: ${spell.concentration}</p>
					      </div>
					    </div>
					  </div>
					</div>
				<tr><td><a href="#" data-toggle="modal" data-target="#modalSpell${spell.index }">${spell.name}</a></td></tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="col-3">
	<table id="charTable" class="table table-striped table-sm">
		<tr><th><a href="#" data-toggle="modal" data-target="#modalFirst">First Level Spells Known:</a>
			<div class="modal fade" id="modalFirst" tabindex="-1" role="dialog" aria-labelledby="firstLabel" aria-hidden="true">
	  				<div class="modal-dialog" role="document">
	   					 <div class="modal-content">
	     					 <div class="modal-header">
	       						 <h5 class="modal-title" id="firstLabel">First Level Spells</h5>
	        						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	         						 <span aria-hidden="true">&times;</span>
	        						</button>
	      					</div>
	     				 	<div class="modal-body">
	     				 	<c:forEach items="${spellcasting.info[2].desc}" var="thing">
	       					<p>${thing}</p>
	       					</c:forEach>
	      					</div>
	    				</div>
	  				</div>
				</div>
			</th></tr>
	<c:forEach var="spell" items="${firstLevelSpells}">
		<div class="modal fade" id="modalSpell${spell.index}" tabindex="-1" role="dialog" aria-labelledby="spellLabel" aria-hidden="true">
  			<div class="modal-dialog" role="document">
   				 <div class="modal-content">
      				<div class="modal-header">
        				<h5 class="modal-title" id="exampleModalLabel">${spell.name }</h5>
       					 <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				 <span aria-hidden="true">&times;</span>
       					 </button>
     				 </div>
     				 <div class="modal-body">
       					<c:forEach var="item" items="${spell.desc}"><p>${item}</p></c:forEach>
					      	<p>Range: ${spell.range} </p>
							<p>Components: ${spell.components}</p>
							<p>Duration: ${spell.duration}</p>
							<p>Casting Time: ${spell.castingTime}</p>
							<p>School: ${spell.school.name}</p>
							<p>Ritual: ${spell.ritual}</p>
							<p>Concentration: ${spell.concentration}</p>
     				 </div>
   				 </div>
  			</div>
		</div>

	<tr><td><a href="#" data-toggle="modal" data-target="#modalSpell${spell.index}">${spell.name}</a></td></tr>
	</c:forEach>
	</table>
	
	</div>
	</div>
	<div class="row">
		<div class="col-1"></div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/" class="btn btn-info mb-5" >Home</a>
			&nbsp; &nbsp; <!-- adds space between buttons -->
		    <a href="/viewCharacterList" class="btn btn-info mb-5">Character List</a>
	</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<c:if test="${newChar}"><script>$('#congrats').modal()</script></c:if>

</body>
</div>
</html>