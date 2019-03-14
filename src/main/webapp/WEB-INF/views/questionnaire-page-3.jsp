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
<form action="/submitResponses">
<input type="hidden" name="q1Response" value="${dndCharacter.q1Response}"/>
<input type="hidden" name="q2Response" value="${dndCharacter.q2Response}"/>
<input type="hidden" name="q3Response" value="${dndCharacter.q3Response}"/>
<input type="hidden" name="q4Response" value="${dndCharacter.q4Response}"/>
<input type="hidden" name="q5Response" value="${dndCharacter.q5Response}"/>
<input type="hidden" name="q6Response" value="${dndCharacter.q6Response}"/>

What do you think of cats?
<select name="q7Response">
  <option value = "1"></option>
  <option value="1">OH MY GOD I LOVE THEM AND THEIR CUTE LITTLE FACES</option>
  <option value="2">I can take 'em or leave 'em</option>
  <option value="3">I loathe cats.</option>
</select>

How do you think political change should come about?
<select name="q8Response">
  <option value = "1"></option>
  <option value="1">By whatever method is chosen in the law</option>
  <option value="2">According to the will of the people</option>
  <option value="3">By any means necessary</option>
</select>
<button type="submit" class="btn btn-primary" value="Submit">Submit</button>
</form>
</body>
</div>
</html>