<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vender Boletos</title>
    </head>
    <body>     
        <c:forEach var="i" items="${ListadoPrueba}">
            ${estaPelicula.MostrarPelicula(i[0].getIdpelicula()).getTitulo()}
            <br>
            <c:forEach var="item2" items="${i}">
             ${item2.getHorainicio()}
            </c:forEach>
            <br>
        </c:forEach>

                
    </body>
</html>
