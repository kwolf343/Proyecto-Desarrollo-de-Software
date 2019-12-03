<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/restringir.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administracion.css" type="text/css"><link>
        <link rel="stylesheet" href="css/AdministraPeliculas.css" type="text/css"><link>
        <title>Peliculas</title>
    </head>
    <body>
        <%@include file="/user.jsp"%>
        <div class="col-12 titulo">
            <h2>Peliculas</h2>
        </div>
        <div class="izquierdo">
            <%@include file="/MenuPrincipal.jsp"%>
            <div class="actualizador"><h2><a href="Principal?op=11">Agregar Pelicula</a></h2></div>
        </div>
        <div class="derecho">
            <div class="contener col-12">
                <div class="col-12">
                    <%@include file="peli.jsp"%>
                </div>
            </div>
            <div class="contener2 col-12">
                <div class="col-6">
                    <a href="Principal?op=10"><center><img src="imagenes/Modificar.png" width="10%"></img></center></a>
                </div>
                <div class="col-6">
                    <a href="Pelis?accion=BorraPelicula"><center><img src="imagenes/Borrar.png" width="10%"></img></center></a>
                </div>
            </div>
                <c:if test="${peliculacomp==true}">
                    <p><br><strong style="color: red">La pelicula no pudo actualizarse por que ya existe otra con el mismo nombre en el registro del cine</strong></p>
                    <div style="display: none">${peliculacomp=false}</div>
                </c:if>
        </div>
    </body>
</html>
