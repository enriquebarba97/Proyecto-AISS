<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/general.css">
<title>Insert title here</title>
</head>
<body>
<fieldset >


<img  alt="img" src='<c:out value="${books.volumeInfo.imageLinks.thumbnail}"/>'><br>
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
</fieldset>

<fieldset>
	<ul>
		<c:forEach items="${requestScope.posts}" var="post">
			<li><a href='http://www.reddit.com<c:out value="${post.permalink}"/>'><c:out value="${post.title}"/></a></li>
		</c:forEach>
	</ul>
</fieldset>

</body>
</html>