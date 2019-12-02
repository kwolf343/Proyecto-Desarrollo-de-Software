<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/session.css" type="text/css"><link>
        <title>Sesión finalizada</title>
    </head>
    <body>
            <center><img src="imagenes/session.png" alt="" width="100%"></center>
            <center><p>¡SU SESION HA EXPIRADO!</p></center>
            <center><h5>HA EXCEDIDO EL TIEMPO INACTIVO</h5></center>
            <center><a onclick="iniciaSesion()"> Iniciar Sesion</a></center>
            
        <script>
            function iniciaSesion(){
                window.history.back();
            }  
        </script> 
        
    </body>
</html>
