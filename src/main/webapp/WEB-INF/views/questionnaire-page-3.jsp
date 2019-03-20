<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questionnaire 3</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<div class="container">
<body>
<form action="/submitResponses">
<br><br><br>
<input type="hidden" name="q1Response" value="${dndCharacter.q1Response}"/>
<input type="hidden" name="q2Response" value="${dndCharacter.q2Response}"/>
<input type="hidden" name="q3Response" value="${dndCharacter.q3Response}"/>
<input type="hidden" name="q4Response" value="${dndCharacter.q4Response}"/>
<input type="hidden" name="q5Response" value="${dndCharacter.q5Response}"/>
<input type="hidden" name="q6Response" value="${dndCharacter.q6Response}"/>
<div class="row">
<div class="col-2"></div>
<div class="col-6">
<div>
What do you think of cats?
<br>
<select class="selections3" name="q7Response" length="70px">
  <option value = "1"></option>
  <option value="1">OMG! I love them and their cute little faces!</option>
  <option value="2">I can take 'em or leave 'em.</option>
  <option value="3">I loathe cats...</option>
</select>
</div>
<br>
<div>
How do you think political change should come about?
<br>
<select class="selections3" name="q8Response">
  <option value = "1"></option>
  <option value="1">By methods established in the law</option>
  <option value="2">According to the will of the people</option>
  <option value="3">By any means necessary</option>
</select>
</div>
<br>
<button type="submit" class="btn btn-info" value="Submit">Submit</button>
</div>
</div>
</form>
</body>
</div>
</html>