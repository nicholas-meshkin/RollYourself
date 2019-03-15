<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<div class="container">
<body>
<form action="/questionnaire-page-3">
<input type="hidden" name="q1Response" value="${dndCharacter.q1Response}"/>
<input type="hidden" name="q2Response" value="${dndCharacter.q2Response}"/>
<input type="hidden" name="q3Response" value="${dndCharacter.q3Response}"/>
<input type="hidden" name="q4Response" value="${dndCharacter.q4Response}"/>
<p>
What comes to mind when you hear "Farming"?
<select name="q5Response">
  <option value = "1"></option>
  <option value="1">People</option>
  <option value="2">Land</option>
  <option value="3">Growth</option>
</select>
</p>
<p>
What do you think about the supernatural?
<select name="q6Response">
  <option value = "1"></option>
  <option value="1">I wish that supernatural things were real</option>
  <option value="2">Belief in the supernatural can be useful</option>
  <option value="3">I believe in the supernatural</option>
  <option value="4">I would believe in the supernatural if I saw some proof</option>
</select>
</p>
<button type="submit" class="btn btn-primary" value="Submit">Submit</button>
</form>
</body>
</div>
</html>