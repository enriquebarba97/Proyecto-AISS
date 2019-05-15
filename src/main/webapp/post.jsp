<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/general.css">
<title>Nuevo post</title>
</head>
<body>

<form class="formu" action="/redditSendPost" method="post">
<fieldset class="lista">
<input type="text" name="title" placeholder="Título de tu Post"><br>
<br>
<textarea class="estilotextarea" name="text" placeholder="Escribe aquí tu post"></textarea><br>
<br>
<input type="checkbox" name="spoiler">Marcar como spoiler
<input class="enviar" type="submit" name="searchBtn" title="send" value="enviar">
</fieldset>
</form>


</body>
</html>