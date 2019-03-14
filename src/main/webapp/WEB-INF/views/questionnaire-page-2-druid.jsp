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
What comes to mind when you hear the word "Nature"?
<select name="q5Response">
  <option value = "1"></option>
  <option value="1">Animals</option>
  <option value="2">Discovery</option>
  <option value="3">Camping</option>
  <option value="4">Science</option>
</select>

What do you think about the supernatural?
<select name="q6Response">
  <option value = "1"></option>
  <option value="1">I wish that supernatural things were real</option>
  <option value="2">I do not believe in anything supernatural</option>
  <option value="3">People who believe in that stuff are dumb</option>
  <option value="4">I believe in the supernatural</option>
  </select>
<button type="submit" class="btn btn-primary" value="Submit">Submit</button>
</form>
</body>
</div>
</html>