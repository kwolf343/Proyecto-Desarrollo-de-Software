<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/restringir.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administracion.css" type="text/css"><link>
        <link rel="stylesheet" href="css/AdministrarBoletos.css" type="text/css"><link>
        <title>Boletos</title>
    </head>
    <body>
        <%@include file="/user.jsp"%>
        <div class="col-12 titulo">
            <h2>Boletos</h2>
        </div>
        <div class="izquierdo">
            <%@include file="/MenuPrincipal.jsp"%>
        </div>
        <div class="derecho arriba">
            <%@include file="boletos.jsp"%>
        </div>
    </body>
</html>
