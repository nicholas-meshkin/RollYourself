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
What comes to mind when you hear the word "Nature"?
<select name="q5Response">
  <option value = "1"></option>
  <option value="1">Animals</option>
  <option value="2">Discovery</option>
  <option value="3">Camping</option>
  <option value="4">Science</option>
</select>
</p>
<p>
What is your reaction to the word "Fight"?
<select name="q6Response">
  <option value = "1"></option>
  <option value="1">Win</option>
  <option value="2">Find Vulnerabilities</option>
  <option value="3">Avoid</option>
  <option value="4">Hide</option>
</select>
</p>
<button type="submit" class="btn btn-primary" value="Submit">Submit</button>
</form>
</body>
</div>
</html>