<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administracion.css" type="text/css"><link>
        <link rel="stylesheet" href="css/venderBoletos.css" type="text/css"><link>
        <title>Vender Boletos</title>
    </head>
    <body>
        <%@include file="/user.jsp"%>
        <div class="col-12 titulo">
            <h2>Vender Boletos</h2>
        </div>
        <div class="izquierdo">
            <%@include file="/MenuPrincipal.jsp"%>
        </div>
        <div class="derecho">
            <div class="a">
                <h1>Paso 1</h1><br><br>
                <h2>Horarios</h2><br>
                <c:forEach var="i" items="${ListadoPrueba}">
                    <h3>${estaPelicula.MostrarPelicula(i[0].getIdpelicula()).getTitulo()}</h3>
                    <c:forEach var="item2" items="${i}">
                        <form name="comp" action="redirecciona?accion=${8000+item2.getIdproyeccion()}" method="POST">
                            <input type="submit" value="${item2.getHorainicio()}" name="v1"/>
                        </form>
                    </c:forEach>
                    <br><br>
                </c:forEach>
                    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            </div>
            <div class="b">
                
            </div>
        </div>    
    </body>
</html>
