<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession();
        if(sesion.getAttribute("Usuario")==null){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Cache-Control","no-store");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires",0);
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administracion.css" type="text/css"><link>
        <link rel="stylesheet" href="css/AdministrarUsuarios.css" type="text/css"><link>
        <title>Usuarios</title>
    </head>
    <body>
        <%@include file="/user.jsp"%>
        <div class="col-12 titulo">
            <h2>Usuarios</h2>
        </div>
        <div class="izquierdo">
            <%@include file="/MenuPrincipal.jsp"%>
        </div>
        <div class="derecho">
            <%@include file="Usuarios.jsp"%>
        </div>
    </body>
</html>
