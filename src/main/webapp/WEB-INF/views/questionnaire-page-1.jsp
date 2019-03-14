<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questionnaire</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="container">
<form action="/questionnaire-page-2">

What most describes your philosophy on your own lifespan?
<div>
<!--  <select name="q1Response">
  <option value = "1"></option>
  <option value="1">5&#39;6&#34; or less</option>
  <option value="2">5&#39;6&#34; - 6&#39;0&#34;</option>
  <option value="3">6&#39;0&#34; - 6&#39;6&#34;</option>
  <option value="4">Over 6&#39;6&#34;</option>
</select>-->
<select name="q1Response">
  <option value = "1"></option>
  <option value="1">Quality over quantity</option>
  <option value="2">I don't think about mortality</option>
  <option value="3">I'm gonna live as long as I possible can</option>
</div>
<p></p>


How would you spend a free weekend with no responsibilities?
<div>
<select name="q2Response">
  <option value = "1"></option>
  <option value="1">Adventure getaway out of town.</option>
  <option value="2">Stay at home and spend time with my family.</option>
  <option value="3">Go out for a nice dinner with friends.</option>
</select>
</div>
<p></p>


Which field best represents your current, former, or future occupation?
<div>
<select name="q3Response">
  <option value = "1"></option>
  <option value="1">Military service, manufacturing, mechanical</option>
  <option value="2">Agriculture, food production, restaurant, environmental</option>
  <option value="3">Education, arts & design, writing, engineering/tech</option>
  <option value="4">Government/public service, sales, human resources, business management</option>
</select>
</div>
<p></p>

<!-- 
A friend tells you they&#39;re having a conflict with a co-worker. You are more likely to:
<div>
<select name="q4Response">
  <option value = "1"></option>
  <option value="1">Confront your friend&#39;s co-worker and tell them off.</option>
  <option value="2">Empathize with your friend, but tell them it&#39;s better to just give in to avoid conflicts.</option>
  <option value="3">Talk to both people and offer to mediate a resolution.</option>
</select>
</div>
<p></p>
 -->
How did you feel about school?
<div>
<select name="q4Response">
  <option value = "1"></option>
  <option value="1">Hated it</option>
  <option value="2">It served its purpose.</option>
  <option value="3">Knowledge is Power!</option>
</select>
</div>
<p></p>
<!-- 
You win an all-expenses-paid trip of your choice. Which do you choose?
<div>
<select name="q5Response">
  <option value = "1"></option>
  <option value="1">A cruise</option>
  <option value="2">A trip to Las Vegas with $5,000 gambling money</option>
  <option value="3">A trip to Hawaii</option>
  <option value="4">Keep the trip; give me the cash value.</option>
</select>
</div>
<p></p>


Your feelings about men&#39;s facial hair:
<div>
<select name="q6Response">
  <option value = "1"></option>
  <option value="1">I prefer a clean-shaven look & a smooth feel.</option>
  <option value="2">I like facial hair, if it&#39;s well-kempt.</option>
  <option value="3">The more hirsute, the merrier -- max beard!</option>
  <option value="4">Whatever floats your boat -- Idc.</option>
</select>
</div>
<p></p>

 -->
<div>
<button type="submit" class="btn btn-primary" value="Submit">Submit</button>
</form>
</div>

</div>
</body>
</html>