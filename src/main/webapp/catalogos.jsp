<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/general.css">
<title>Catalogos</title>
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
	<div class="separador2"></div>
<fieldset class="lista">
<legend >Catálogo de libros disponibles para su búsqueda: <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.books}" var="books">
  <a href="/bookShowController?volumeID=${books.id}"> <c:out value="${books.volumeInfo.title}"/></a>  <br>
</c:forEach>

</fieldset>


</body>
</html>