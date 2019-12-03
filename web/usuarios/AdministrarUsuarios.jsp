<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/restringir.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administracion.css" type="text/css"><link>
        <link rel="stylesheet" href="css/AdministrarUsuarios.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Registro.css" type="text/css"><link>
        <title>Usuarios</title>
    </head>
    <body>
        <%@include file="/user.jsp"%>
        <div class="col-12 titulo">
            <h2>Usuarios</h2>
        </div>
        <div class="izquierdo">
            <%@include file="/MenuPrincipal.jsp"%>
            <br><br>
            <div class="insercion">
                <a href="Usuario?accion=nuevo"><h2>Nuevo usuario</h2></a>
            </div>
        </div>
        <div class="derecho">
            <c:if test="${InsertarBoleto!=true}">
                <%@include file="Usuarios.jsp"%>
            </c:if>
            <c:if test="${InsertarBoleto==true}">
                <%@include file="/Registro.jsp"%>
                <div style="display: none">${InsertarBoleto=false}</div>
            </c:if>
        </div>
    </body>
</html>
