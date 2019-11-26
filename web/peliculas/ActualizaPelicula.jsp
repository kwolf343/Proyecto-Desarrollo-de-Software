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
                <div class="col-9">
                    <%@include file="peli.jsp"%>
                </div>
                <div class="contener3 col-3">
                <form name="actualizap" action="Pelis?accion=ActualizarPelicula" method="POST">
                    <div class="col-12">Titulo: </div><div><input type="text" name="tituloP"></div>
                    <div class="col-12">Duración: </div><div class="tiempo">
                        <input type="number" name="hora" min="0" max="12" required>:
                        <input type="number" name="minuto" min="0" max="59" required>:
                        <input type="number" name="segundo" min="0" max="59" required>
                    </div>
                    <div class="col-12">Clasificación: </div><div>
                        <select name="clasificacion" required>
                            <option value="A">A</option>
                            <option value="B">B</option>
                            <option value="C">C</option>
                            <option value="D">D</option>
                        </select>
                    </div>
                    <div class="col-12">Generos: </div><div>
                        <select name="generos" required>
                            <option value="Accion">Accion</option>
                            <option value="Comedia">Comedia</option>
                            <option value="Drama">Drama</option>
                            <option value="Romance">Romance</option>
                            <option value="Aventura">Aventura</option>
                        </select>
                    </div>
                    <div class="col-12">Fecha de estreno: </div><div>
                        <input type="date" name="estreno"  required>
                    </div>
                    <div class="col-12">Fecha de salida: </div><div>
                        <input type="date" name="salida"  required>
                    </div>
                    <div class="col-12">Sinopsis: </div><div><input type="text" name="sinopsisP"></div>
                    <br>
                    <div class="col-12"><input type="submit" value="Actualizar" name="enviar3"/></div>
                </form>
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
        </div>
    </body>
</html>
