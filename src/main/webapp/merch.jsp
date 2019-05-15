<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/general.css">
<title>Merchandaising</title>
</head>
<body>

<div >
	<fieldset class="lista">
<legend style="color:#FACC70;"> Merchandaising</legend>

<c:forEach items="${requestScope.productos}" var="prod">
<aside class="lista3">
<img id="cover" alt="merch" src='<c:out value="${prod.imageUrl}"></c:out>'/><br>
<span>Producto: <c:out value="${prod.title}"></c:out> </span><br>
<c:forEach items="${prod.priceOptions}" var="precio">

<span>Precios: <c:out value="${precio.amount.value}"></c:out><c:out value="${precio.amount.currency}"></c:out>  </span><br>

</c:forEach>

</aside>
</c:forEach>

</fieldset>
</div>
</body>
</html>