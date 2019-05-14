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
<form action="/redditSendPost" method="post">
<input type="text" name="title">
<textarea name="text"></textarea>
<input type="checkbox" name="spoiler">Marcar como spoiler
<input class="enviar" type="submit" name="searchBtn" title="send" value="enviar">
</form>
</body>
</html>