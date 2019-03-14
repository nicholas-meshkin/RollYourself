<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<div class="container">
<body>
<form action="/questionnaire-page-3">
<input type="hidden" name="q1Response" value="${dndCharacter.q1Response}"/>
<input type="hidden" name="q2Response" value="${dndCharacter.q2Response}"/>
<input type="hidden" name="q3Response" value="${dndCharacter.q3Response}"/>
<input type="hidden" name="q4Response" value="${dndCharacter.q4Response}"/>
What is your response to the word "Fight"?
<select name="q5Response">
  <option value = "1"></option>
  <option value="1">Talk</option>
  <option value="2">Injury</option>
  <option value="3">War</option>
</select>

What do you think about the supernatural?
<select name="q6Response">
  <option value = "1"></option>
  <option value="1">I do not believe in anything supernatural</option>
  <option value="2">I believe in the supernatural</option>

</select>
<button type="submit" class="btn btn-primary" value="Submit">Submit</button>
</form>
</body>
</div>
</html>