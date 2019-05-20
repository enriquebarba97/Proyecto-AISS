<%@ page language="java" contentType="text/html;  charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/general.css">
<title>Catalogos</title>
</head>
<body>
 <div class="separador">
 <div class="loguea">
	<c:choose>
		<c:when test='${sessionScope["Reddit-user"] != null}'>
		<div class="letra">
    		Bienvenido <c:out value='${sessionScope["Reddit-user"]}'/> 
    	</div>
    	<div>
    		<a href="/redditLogOut">Cerrar sesi�n</a>
    	</div>
		</c:when>
		<c:otherwise>
			<div >
				<a href="https://ssl.reddit.com/login"> Reg�strate en Reddit</a>
			</div>
			<div >
				<a href="/RedditAuthController"> Entra en Reddit</a>
			</div>
		</c:otherwise>
	</c:choose>
	<div>
	
	</div>
	</div>
    <img class="logo" alt="logo" src="img/prueba.png">
    </div >
    <div class="separador">
		<form  action="/bookSearchController" method="post">
			<input class="busqueda" type="text" name="searchQuery" placeholder="Busque por titulo, autor" required/> 
			<div class="separador2"></div>
			<input class="enviar" type="submit" name="searchBtn" title="search" value="buscar" >
		</form>
	</div>
	<div class="separador2"></div>

<fieldset class="lista">
<legend style="color:white;">Cat�logo de libros disponibles para su b�squeda: <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.books}" var="books">
  <a href="/bookShowController?volumeID=${books.id}"> <c:out value="${books.volumeInfo.title}"/></a>  <br>
</c:forEach>

</fieldset>

<div>
	<video autoplay="autoplay" loop="loop"  id="video_background" preload="auto" muted="muted"/>
  		<source src="img/The Joy of Books.mp4" type="video/mp4" />
	</video/>
	</div>


</body>
</html>