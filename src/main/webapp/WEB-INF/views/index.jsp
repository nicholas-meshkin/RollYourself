<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Roll Yourself!</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
<link href='https://fonts.googleapis.com/css?family=Metal Mania' rel='stylesheet'>
</head>
<style>
#logo {
    font-family: 'Metal Mania'; font-size:40pt;color: #E22F0F;
}
html {
height: 100%;
}
body{
height:100%;
 background-size: auto 100%;
 background-position: center;
 background-repeat: no-repeat;
 background-image: url("/images/Norvell's_Witch.png");
}
.row{
margin: auto;
  width: 50%;
}
#artcredit{
 width:300px;
  position:absolute;
  bottom:0%;
  left:65%;
}
#button1{
width:300px;
  position:absolute;
  top:25%;
  left:70%;
}
#button2{
width:300px;
  position:absolute;
  top: 35%;
  left:70%;
}
/*
html, body = height 100%
background-size  auto 100%
background-position center
background-repeat no-repeat
*/
</style>
</head>
<body>
<div class="container">
<div class="row">
<h1 >Welcome to</h1>&nbsp;&nbsp;<h1 id="logo"> RollYourself</h1></div>

<a id="button1" class="btn btn-info" href="/questionnaire">Create your personal D&D avatar.</a>
<p></p>
<a id="button2" class="btn btn-info" href="/viewCharacterList">List of saved characters</a>
<div id="artcredit" class="mb-2">art by michael a. seaton</div>
</div>
</body>
</html>