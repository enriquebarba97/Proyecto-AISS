<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/general.css">
<title>Coment</title>
</head>
<body>


<aside class="lista2">

<img id="cover" alt="img" src='<c:out value="${books.volumeInfo.imageLinks.thumbnail}"/>'><br>

<span> <c:out value="${books.volumeInfo.title}"/> </span><br>
<span> <c:out value="${books.volumeInfo.authors}"/> </span><br>
<c:forEach items="${requestScope.books.volumeInfo.industryIdentifiers}" var="ident">
	<c:if test="${ident.type== 'ISBN_13' }">
		<span><c:out value="${ident.identifier}"/></span>
	</c:if>
	
</c:forEach>

<br>

<span>Rating: <c:out value="${books.volumeInfo.averageRating}"/> </span><br>
<span>Precio: <c:out value="${books.saleInfo.listPrice.amount}"/> &nbsp <c:out value="${books.saleInfo.listPrice.currencyCode}"/> </span>
<br>
<a href="/MerchController?title=${requestScope.title}">Ver productos relacionados</a>

</aside>
<div class="separador">
<fieldset class="lista">
<legend  style="color:#FACC70;"> Review en IdreamBooks</legend>
<ul>
<c:forEach items="${requestScope.reviews.book.criticReviews}" var="review">
	<li><c:out value="${review.snippet}"/> (<c:out value="${review.source}"/>) </li>
</c:forEach>
</ul>
</fieldset>
</div>
<div class="separador">
<fieldset class="lista">
	<legend > Reddit links</legend>
	<ul>
		<c:forEach items="${requestScope.posts}" var="post">
			<li><a href='http://www.reddit.com<c:out value="${post.permalink}"/>'><c:out value="${post.title}"/></a></li>
		</c:forEach>
	</ul>
	<br>
	<form action="/redditNewPost" method="post">
	<input type="hidden" name="title" value='<c:out value="${books.volumeInfo.title}"/>'>
	<button type="submit">Postear en r/books</button>
	</form>
</fieldset>
</div>


</body>
</html>