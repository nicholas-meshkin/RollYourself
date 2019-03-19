<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="refresh" content="4;url=/newCharacter?id=${id}">
<title>Loading...</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<div class="container">
<body>
<br><br><br><br><br><br>
<div class="row">
<div class="col-4"></div>
<div class="col-4">
<h3>Please wait while we roll your character...</h3>
<br>
<br>
<div class="row">
<div class="col-4"></div>
<div class="spinner-border text-danger" role="status" style="width: 5rem; height: 5rem;">
  <span class="sr-only"></span>
</div>
</div>
</div>

</div>
</body>
</div>
</html>