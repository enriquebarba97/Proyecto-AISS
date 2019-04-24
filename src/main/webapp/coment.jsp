<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset >
<legend >Búsqueda de : <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.books}" var="books">
<img alt="img" src='<c:out value="${books.volumeInfo.imageLinks.thumbnail}"/>'>
   
</c:forEach>

</fieldset>


</body>
</html>