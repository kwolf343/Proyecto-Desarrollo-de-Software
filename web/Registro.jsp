<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/Registro.css" type="text/css"><link>
    <title>Registro</title>
</head>
<body>
    
    <section class="contenedorR row">
        <div class="contflexRgt">
            <div class="registro">
                <div>
                <div>
                    <p>CINE CREIZY</p>
                    <br>
                    <br>
                </div>
                    <form action="/Proyecto_Desarrollo_de_Software/Registro" method="post">
                        <div class="formulariop1">
                            <input class="cjtext" type="text" name="usuario" placeholder="Nombre de usuario" required>
                        </div>
                        <div class="formulariop1">
                            <input class="cjtext" type="text" name="nombre" placeholder="Nombre" required>
                        </div>
                        <div class="formulariop1">
                            <input class="cjtext" type="text" name="apellido" placeholder="Apellido"required >
                        </div>
                        <div class="formulariop1">
                            <input class="cjtext" type="text" name="targeta" placeholder="Targeta"required >
                        </div>
                        <div class="formulariop1">
                            <input class="cjtext" type="email" name="correo"  placeholder="Correo electronico" required >
                        </div>
                        <div class="formulariop1">
                            <input class="cjtext" type="password" name="contra" placeholder="Contraseña" required>
                        </div>   
                        <div class="formulariop2">
                            <label for="doc">Pais:</label>
                            <select name="pais" required>
                                <option value="1">El Salvador</option>
                                <option value="2">Nicaragua</option>
                                <option value="3">Costa Rica</option>
                                <option value="4">Guatemala</option>
                                <option value="5">Panama</option>
                                <option value="6">Honduras</option>
                                <option value="7">Belice</option>
                            </select>
                        </div>
                        <div class="formulariop2">
                            <input type="checkbox" id="check" name="check" required>
                            <label for="check">Aceptar los terminso y condiciones</label>
                        </div>
                        <div class="botones">
                            <ul>
                                <input id="boton" type="submit" value="Registrarme">
                                puto
                            </ul>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>

