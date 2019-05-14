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

</aside>

<fieldset class="lista">
<legend> Review en IdreamBooks</legend>
<c:forEach items="${requestScope.reviews.book.criticReviews}" var="review">
<span><c:out value="${review.snippet}"/> </span>
</c:forEach>
</fieldset>
<fieldset class="lista">
	<legend> Reddit links</legend>
	<ul>
		<c:forEach items="${requestScope.posts}" var="post">
			<li><a href='http://www.reddit.com<c:out value="${post.permalink}"/>'><c:out value="${post.title}"/></a></li>
		</c:forEach>
	</ul>
	<br>
	<a href="/post.jsp">Postear en r/books</a>
</fieldset>
<fieldset class="lista">
<legend> Merchandaising</legend>

<c:forEach items="${requestScope.productos}" var="prod">
<aside class="lista">
<img id="cover" alt="merch" src='<c:out value="${prod.imageUrl}"></c:out>'/>
<span> <c:out value="${prod.title}"></c:out> </span>
<c:forEach items="${prod.priceOptions}" var="precio">
<span><c:out value="${precio.amount.value}"></c:out>  </span>
<span><c:out value="${precio.amount.currency}"></c:out>   </span>
</c:forEach>

</aside>
</c:forEach>

</fieldset>

</body>
</html>