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

<fieldset class="lista">
<legend >Catálogo de libros disponibles para su búsqueda: <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.books}" var="books">
<span ><c:out value="${books.volumeInfo.title}"/> </span><br>
</c:forEach>

</fieldset>


</body>
</html>