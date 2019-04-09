<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>
<table>
	<tr><th>Spell</th><th>Level</th></tr>
<c:forEach var="spell" items="${spells}">
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
	
	<tr><td><a href="#" data-toggle="modal" data-target="#modalSpell${spell.index}">${spell.name}</a></td><td>${spell.level}</td></tr>
		</c:forEach>
	</table>




<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>