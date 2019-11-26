<%@include file="/restringir.jsp"%>
<%@page import="com.cine_creizy.CRUD.CTipodeboletos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <form name="actualizab" action="Boleto?accion=ActualizaBoleto" method="POST">
                <h2>Actualizar</h2>
                <br>
                <h4>Boleto ${FormatoTipoBoletos}<br>Tipo ${TipoTipoBoletos}</h4>
                <br>
                <div class="col-6">Precio: </div><div class="caja"><input type="number" step="0.01" name="precio"></div>
                <br>
                <div class="boton"><input type="submit" value="Actualizar" name="enviar"/></div>
            </form>
        </div>
        <div class="derecho arriba">
            <%@include file="boletos.jsp"%>
        </div>
    </body>
</html>
