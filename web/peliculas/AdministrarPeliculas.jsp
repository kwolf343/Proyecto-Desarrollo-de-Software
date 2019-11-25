<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administracion.css" type="text/css"><link>
        <link rel="stylesheet" href="css/AdministraPeliculas.css" type="text/css"><link>
        <title>JSP Page</title>
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
            <div class="pelis col-12">
                <ul>
                    <li class="numero"><center>N°</center></li>
                    <li class="ti"><center>Titulo</center></li>
                    <li class="clasificacion"><center>Clasificación</center></li>
                    <li class="fecha"><center>Fecha de estreno</center></li>
                    <li class="genero"><center>Generos</center></li>
                    <li class="Minfo"><center>Ver</center></li>
                </ul>
            </div>
            <div class="pelicul col-12">
                <c:forEach var="peliculas" items="${ListaPeliculas}">
                    <ul>
                    <li class="numero"><center>${peliculas.getIdpelicula()}</center></li>
                    <li class="ti">${peliculas.getTitulo()}</li>
                    <li class="clasificacion"><center>${peliculas.getClasificacion()}</center></li>
                    <li class="fecha"><center>${peliculas.getFecha_De_Llegada()}</center></li>
                    <li class="genero"><center>${peliculas.getGenero()}</center></li>
                    <a href="redirecciona?accion=${3000+peliculas.getIdpelicula()}"><li class="Minfo"><center><img src="imagenes/editar.png" width="14%"></center></li></a>
                    </ul>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
