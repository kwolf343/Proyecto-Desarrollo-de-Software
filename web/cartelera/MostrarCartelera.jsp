<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administracion.css" type="text/css"><link>
        <link rel="stylesheet" href="css/MostrarCartelera.css" type="text/css"><link>
        <title>Cartelera</title>
    </head>
    <body>
        <%@include file="/user.jsp"%>
        <div class="col-12 titulo">
            <h2>Cartelera</h2>
        </div>
        <div class="izquierdo">
            <%@include file="/MenuPrincipal.jsp"%>
        </div>
        <div class="derecho">
            <div class="col-12 informacion">
                <h3>Id: ${IdCartelera}</h3>
                <br>
                <h3>Pelicula: ${PeliculaProyeccion}</h3>
                <br>
                <h3>Hora de inicio: ${HoraInicioProyeccion}</h3>
                <br>
                <h3>Hora de fin: ${HoraFinProyeccion}</h3>
                <br>
                <h3>Sala: ${SalaProyeccion}</h3>
            </div>
            <div class="col-12 aqui">
                <div class="col-6">
                    <a href="Principal?op=14"><center><img src="imagenes/Modificar.png" width="10%"></img></center></a>
                </div>
                <div class="col-6">
                    <a href="Cartelera?accion=BorraCartelera"><center><img src="imagenes/Borrar.png" width="10%"></img></center></a>
                </div>
            </div>
        </div>
    </body>
</html>
