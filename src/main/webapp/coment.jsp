<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/general.css">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

<title>Coment</title>
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
<div  style="float:right"> <a href="/index.jsp"> Inicio </a> &nbsp
<a href="/MerchController?title=${requestScope.title}">Ver productos relacionados</a> </div>
</div> 


<aside class="lista2">

<img id="cover2" alt="img" src='<c:out value="${books.volumeInfo.imageLinks.thumbnail}"/>'><br>
<div class="espacios2">
<span style="font-weight: bold;"> <c:out value="${books.volumeInfo.title}"/> </span><br>
<span> <c:out value="${books.volumeInfo.authors}"/> </span><br>
<c:forEach items="${requestScope.books.volumeInfo.industryIdentifiers}" var="ident">
	<c:if test="${ident.type== 'ISBN_13' }">
		<span><c:out value="${ident.identifier}"/></span>
	</c:if>
	
</c:forEach>

<br>

<span>Rating: <c:out value="${books.volumeInfo.averageRating}"/> </span><br>
<span>Precio: <c:out value="${books.saleInfo.listPrice.amount}"/> &nbsp <c:out value="${books.saleInfo.listPrice.currencyCode}"/> </span>
</div>


<c:choose>
<c:when test="${not empty requestScope.logged}">
<form action="/bookShelfControlller" method="post">
<input type="hidden" name="volumeId" value="${books.id}">
	<c:choose>
	
		<c:when test="${empty requestScope.estado}">
			<input type="submit" name="envio" value="añadir">

		</c:when>
		<c:otherwise>
		<input type="submit" name="envio" value="eliminar">
		</c:otherwise>
	</c:choose>
	
</form>
</c:when>
<c:otherwise>
 <a href="/AuthController/GoogleBooks"> Logueate </a>
</c:otherwise>
</c:choose>
</aside>

<fieldset class="lista">
<legend class="espacios2"  style="color:#FACC70;font-weight: bold;"> Críticas de <c:out value="${books.volumeInfo.title}"/> </legend>
<ul>
<div class="espacios2" >
<c:forEach items="${requestScope.reviews.book.criticReviews}" var="review">
	<li><c:out value="${review.snippet}"/> (<c:out value="${review.source}"/>) </li>
</c:forEach>
</ul>
</div>
<br>
</fieldset>
</div>
<div class="separador2">

<fieldset class="lista4">
	<legend class="espacios2" style="font-weight: bold;"> Hilos sobre  <c:out value="${books.volumeInfo.title}"/> </legend>
	<img style="height:35px; width:55px; border-radius:5px;" alt="reddit" src="img/red.jpg">
	<div class="espacios" >
	<ul>
		<c:forEach items="${requestScope.posts}" var="post">
			<li><a href='http://www.reddit.com<c:out value="${post.permalink}"/>'><c:out value="${post.title}"/></a></li>
		</c:forEach>
	</ul>
	</div>
	<br>
	<form action="/redditNewPost" method="post">
	<input type="hidden" name="title" value='<c:out value="${books.volumeInfo.title}"/>'>
	<button type="submit">Postear en r/books</button>
	</form>
</fieldset>
</div>


</body>
</html>