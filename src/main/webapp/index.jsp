<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/general.css">
    <title>Book Assistant</title>
  </head>

  <body>
    <div class="separador">
    <img class="logo" alt="logo" src="img/prueba.png">
    </div >
    <div class="separador">
		<form  action="/bookSearchController" method="post">
			<input class="busqueda" type="text" name="searchQuery" placeholder="Busque por titulo, autor" required/> 
			<div class="separador2"></div>
			<input class="enviar" type="submit" name="searchBtn" title="search" value="buscar" >
		</form>
	</div>
	<c:choose>
		<c:when test='${sessionScope["Reddit-user"] != null}'>
		<div>
    		Bienvenido <c:out value='${sessionScope["Reddit-user"]}'/> 
    	</div>
    	<div>
    		<a href="/redditLogOut">Cerrar sesión</a>
    	</div>
		</c:when>
		<c:otherwise>
			<div >
				<a href="https://ssl.reddit.com/login"> Regístrate en Reddit</a>
			</div>
			<div>
				<a href="/RedditAuthController"> Entra en Reddit</a>
			</div>
		</c:otherwise>
	</c:choose>
    
  </body>
</html>