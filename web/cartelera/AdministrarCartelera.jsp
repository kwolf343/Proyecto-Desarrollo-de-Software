<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/restringir.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administracion.css" type="text/css"><link>
        <link rel="stylesheet" href="css/AdministrarCartelera.css" type="text/css"><link>
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
            <div class="col-12 arriba">
                <ul>
                    <li class="Id"><center>ID</center></li>
                    <li class="Peli"><center>Pelicula</center></li>
                    <li class="HI"><center>Hora Inicio</center></li>
                    <li class="HF"><center>Hora Fin</center></li>
                    <li class="S"><center>Sala</center></li>
                    <li class="V"><center>Ver</center></li>
                </ul>
            </div>
            <br><br>
            <div class="col-12 abajo">
                <c:forEach var="proyeccion" items="${ListaProyecciones}">
                    <ul>
                        <li class="Id"><center>${proyeccion.getIdproyeccion()}</center></li>
                        <li class="Peli">${estaPelicula.MostrarPelicula(proyeccion.getIdpelicula()).getTitulo()}</li>
                        <li class="HI"><center>${proyeccion.getHorainicio()}</center></li>
                        <li class="HF"><center>${proyeccion.getHorafin()}</center></li>
                        <li class="S"><center>${estaSala.MostrarSalas(proyeccion.getIdsala()).getSala()}</center></li>
                        <a href="redirecciona?accion=${6000+proyeccion.getIdproyeccion()}"><li class="V"><center><img src="imagenes/editar.png" width="15%"></center></li></a>
                    </ul>
                </c:forEach>
            </div>
            <div class="registrarCartelera col-12">
                <form name="agregaC" action="Cartelera?accion=AgregarCartelera" method="POST">
                <ul>
                    <li class="Id"><center>Agregar</center></li>
                        <li class="Peli">
                            <select name="Pelic" required>
                                <c:forEach var="pelis" items="${ListaPeliculas}">
                                    <option value="${pelis.getIdpelicula()}">${pelis.getTitulo()}</option>
                                </c:forEach>
                            </select>
                        </li>
                        <li class="HI"><center><input type="time" name="HoradeInicio" required></center></li>
                        <li class="HF"><center><input type="time" name="HoradeFin" required></center></li>
                    <li class="S">
                        <select name="Sala" required>
                        <c:forEach var="salas" items="${ListaSalas}">
                            <option value="${salas.getIdsala()}">${salas.getSala()}</option>
                        </c:forEach>
                        </select>
                    </li>
                    <li class="V"><input type="submit" value="Agregar" name="enviar"/></li>
                </ul>
                </form>
            </div>
            <form class="col-12 formu" name="ventaB" action="${pageContext.servletContext.contextPath}/Reportes?accion=sala" method="POST">
                Reporte Salas   -    Sala: <input type="text" name="sal" required>
                <input type="submit">
            </form>
        </div>
    </body>
</html>
