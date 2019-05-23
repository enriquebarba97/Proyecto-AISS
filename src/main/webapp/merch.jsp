<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=UTF-8">
<link rel="icon" href="img/prueba.png">
<link rel="stylesheet" type="text/css" href="css/general.css">
<title>Merchandising</title>
</head>
<body>
<div class="lista5">

<div  style="float:right"> <a href="/index.jsp"> Inicio </a> &nbsp
<a href="javascript:history.back(-1);"> Atrás </a> </div>
</div> 
<div >
	<fieldset class="lista">
<legend class="letras" style="color:#FACC70;"> Merchandaising</legend>


<c:forEach items="${requestScope.productos}" var="prod">
<aside class="lista3">
<img id="cover" alt="merch" src='<c:out value="${prod.imageUrl}"></c:out>'/><br>
<div class="espacios">
<span style="font-weight: bold;"><c:out value="${prod.title}"></c:out> </span><br>
<c:forEach items="${prod.priceOptions}" var="precio">

<span >Precios: <c:out value="${precio.amount.value}"></c:out><c:out value="${precio.amount.currency}"></c:out>  </span><br>

</c:forEach>
</div>
</aside>
</c:forEach>

</fieldset>
</div>
</body>
</html>