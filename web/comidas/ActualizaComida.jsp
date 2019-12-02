<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/restringir.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administracion.css" type="text/css"><link>
        <link rel="stylesheet" href="css/AdministrarComida.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Actualizador.css" type="text/css"><link>
        <title>Comida</title>
    </head>
    <body>
        <%@include file="/user.jsp"%>
        <div class="col-12 titulo">
            <h2>Comida</h2>
        </div>
        <div class="izquierdo">
            <%@include file="/MenuPrincipal.jsp"%>
            <div class="actualiza">
                <form name="actualizau" action="Comida?accion=ActualizaComida" method="POST">
                    <h4>Actualizar ${comida}</h4>
                    <br>
                    <div class="col-6">Nombre: </div><div class="caja"><input type="text" name="nombre" required></div>
                    <div class="col-6">Precio: </div><div class="caja"><input type="number" step="0.01" name="precio" required></div>
                    <div class="col-6">Existencias: </div><div class="caja"><input type="number" name="existencias" required></div>
                    <br>
                    <div class="boton"><input type="submit" value="Actualizar" name="enviar"/></div>
                </form>
            </div>
        </div>
        <div class="derecho">
            <%@include file="comida.jsp"%>
        </div>
    </body>
</html>
