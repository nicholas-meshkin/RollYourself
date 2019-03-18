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
I say, &#39;AGRICULTURE.&#39; You say __________
<select name="q5Response">
  <option value = "1"></option>
  <option value="1">Silo</option>
  <option value="2">Scythe</option>
  <option value="3">Drought</option>
</select>
</p>
<p>
I say, &#39;SUPERNATURAL.&#39; You say __________
<select name="q6Response">
  <option value = "1"></option>
  <option value="1">Stonehenge</option>
  <option value="2">God</option>
  <option value="3">Ouija</option>
  </select>
</p>
<button type="submit" class="btn btn-primary" value="Submit">Submit</button>
</form>
</body>
</div>
</html>