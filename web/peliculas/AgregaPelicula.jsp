<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/restringir.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administracion.css" type="text/css"><link>
        <link rel="stylesheet" href="css/AdministraPeliculas.css" type="text/css"><link>
        <link rel="stylesheet" href="css/AgregaPelicula.css" type="text/css"><link>
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
            <form name="agregap" action="Pelis?accion=Agregarpeli" method="POST">
                <div class="formulario_peli col-12">
                    <br>
                    <div class="col-12"><h2><center>Agregar peliculas</center></h2></div>
                    <br><br><br><br><br><br>
                    <div class="col-12">
                        <div class="col-4"><h3>Titulo de la pelicula:</h3></div>
                        <div class="input1 col-8"><input type="text" name="titulo" required></div>
                    </div>
                    <br><br><br>
                    <div class="col-12">
                        <div class="col-4"><h3>Duración:</h3></div>
                        <div class="caja col-3">
                            <input type="number" name="hora" min="0" max="12" required>:
                            <input type="number" name="minuto" min="0" max="59" required>:
                            <input type="number" name="segundo" min="0" max="59" required>
                        </div>
                    </div>
                    <br><br><br>
                    <div class="col-12">
                        <div class="col-4"><h3>Clasificación:</h3></div>
                        <div class="col-8">
                            <select name="clasificacion" required>
                                <option value="A">A</option>
                                <option value="B">B</option>
                                <option value="C">C</option>
                                <option value="D">D</option>
                            </select>
                        </div>
                    </div>
                    <br><br><br>
                    <div class="col-12">
                        <div class="col-4"><h3>Generos:</h3></div>
                            <div class="col-4">
                                <select name="generos" required>
                                    <option value="Accion">Accion</option>
                                    <option value="Comedia">Comedia</option>
                                    <option value="Drama">Drama</option>
                                    <option value="Romance">Romance</option>
                                    <option value="Aventura">Aventura</option>
                                </select>
                            </div>
                    </div>
                    <br><br><br>
                    <div class="col-12">
                        <div class="col-4"><h3>Fecha de estreno:</h3></div>
                        <div class="col-8"><input type="date" name="estreno"  required></div>
                    </div>
                    <br><br><br>
                    <div class="col-12">
                        <div class="col-4"><h3>Fecha de salida:</h3></div>
                        <div class="col-8"><input type="date" name="salida" required></div>
                    </div>
                    <br><br><br><br>
                    <div class="col-12"><h3>Sinopsis:</h3></div>
                    <br>
                    <div class="col-12"><textarea name="sinopsis" rows=15 style="min-width: 100%" required></textarea></div>
                    <br><br><br><br>
                    <div class="col-12 b"><input type="submit" value="Agregar"></div>
                </div>
            </form>
        </div>
    </body>
</html>
