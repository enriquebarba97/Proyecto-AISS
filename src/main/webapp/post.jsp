<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/general.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<title>Nuevo post</title>
<script>
			$(function(){
		       $('#login').click(function(){
			   $(this).next('#login-content').slideToggle();
			   $(this).toggleClass('active');          
			   });
			});
		</script>
</head>
<body>
<div class="lista5">
<nav class="acceder">
		   <ul>
		      <li>
		         <a id="login" href="#">Busca otro título</a>
		         <div id="login-content">
		            <form  action="/bookSearchController" method="post">
			<input class="busqueda" type="text" name="searchQuery" placeholder="Busque por titulo, autor" required/> 
			<div class="separador2"></div>
			<input class="enviar" type="submit" name="searchBtn" title="search" value="buscar" >
		</form>
			     </div>                     
		      </li>
		   </ul>
		</nav>
<div  style="float:right"> <a href="/index.jsp"> Inicio </a></div>
</div>
<form class="formu" action="/redditSendPost" method="post">
<fieldset class="lista">
<input type="text" name="title" placeholder="Título de tu Post" value='${requestScope.title}'><br>
<br>
<textarea id = "text" class="estilotextarea" name="text" placeholder="Escribe aquí tu post"></textarea><br>
<br>
<input type="checkbox" name="spoiler">Marcar como spoiler
<input class="enviar" type="submit" name="searchBtn" title="send" value="enviar">

</fieldset>
</form>


</body>

<script>
var simplemde = new SimpleMDE({ 
	placeholder: "Escribe aquí",
	element: document.getElementById("text"),
	spellChecker: false
	});
</script>
</html>