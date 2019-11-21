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
                <div class="col-8">
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
                <div class="col-4">
                    <form name="actualizau" action="Cartelera?accion=ActualizaCartelera" method="POST">
                    <h2>Actualizar Cartelera</h2>
                    <br>
                    <h4>Pelicula:</h4>
                    <select name="Pelicula" required>
                        <c:forEach var="pelis" items="${ListaPeliculas}">
                            <option value="${pelis.getIdpelicula()}">${pelis.getTitulo()}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <h4>Hora de inicio:</h4>
                    <input type="time" name="HoradeInicio" required>
                    <br>
                    <h4>Hora de fin:</h4>
                    <input type="time" name="HoradeFin" required>
                    <br>
                    <h4>Sala</h4>
                    <select name="Sala" required>
                        <c:forEach var="salas" items="${ListaSalas}">
                            <option value="${salas.getIdsala()}">${salas.getSala()}</option>
                        </c:forEach>
                    </select>
                    <br><br>
                    <input id="btn" type="submit" value="Actualizar" name="enviar"/>
                    </form>
                </div>
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
