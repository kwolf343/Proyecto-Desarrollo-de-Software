<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administracion.css" type="text/css"><link>
        <link rel="stylesheet" href="css/AdministrarUsuarios.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administrar.css" type="text/css"><link>
        <title>Cine Creizy</title>
    </head>
    
    <body>
        <%@include file="user.jsp"%>
        <div class="col-12 titulo">
          
        </div>
        <div class="izquierdo">
            <%@include file="MenuPrincipal.jsp"%>
        </div>
        <div class="derecho" >
            <div class="contenido"> 
            <center><img src="imagenes/Logo2.png" alt="" width="100%"></center>
            <br>
            <center><h1>¡BIENVENIDOS!</h1></center>
           <br>
        <center><p>Cine Creizy ® Derechos Reservados. </p></center>
            </div>
        </div> 
    </body>
</html>
