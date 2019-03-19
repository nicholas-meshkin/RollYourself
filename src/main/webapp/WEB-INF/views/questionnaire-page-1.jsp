<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questionnaire</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
<form action="/questionnaire-page-2">
<br><br><br>
<div class="row">
<div class="col-2"></div>
<div class="col-6">

<div>
Select the statement that best fits your approach to life:
<select class="selections1" name="q1Response" >
  <option value = "1"></option>
  <option value="1"> Live fast; die young.</option>
  <option value="2">Don&#39;t overthink it: accept your fate.</option>
  <option value="3">Try to live long and prosper.</option>
  </select>
</div>
<p></p>

<div>
How would you spend a free weekend with no responsibilities?
<select class="selections1" name="q2Response">
  <option value = "1"></option>
  <option value="1"> It&#39;s &#34;Me Time&#34;: stay home and do what I want.</option>
  <option value="2">Spend time with my family: maybe visit with relatives.</option>
  <option value="3">Let&#39;s party! Time to go out with friends & meet new people.</option>
</select>
</div>
<p></p>

<div>
Which field best represents your current, former, or future occupation?
<select class="selections1" name="q3Response">
  <option value = "1"></option>
  <option value="1">Military service, manufacturing, mechanical</option>
  <option value="2">Agriculture, food production, restaurant, environmental</option>
  <option value="3">Education, arts & design, writing, engineering/tech</option>
  <option value="4">Government/public service, sales, human resources, business management</option>
</select>
</div>
<p></p>

<div>
Which best describes your attitude toward learning?
<select class="selections1" name="q4Response">
  <option value = "1"></option>
  <option value="1">I&#39;ve already graduated, so no thanks.</option>
  <option value="2">Only if this learning helps me make money.</option>
  <option value="3">The pursuit of knowledge is its own reward.</option>
</select>
</div>
<p></p>
<div>
<button type="submit" class="btn btn-primary" value="Submit">Submit</button>
</div>
</div>
<div class="col-2"></div>
</form>
</div>

</div>
</body>
</html>