<%@page import="com.cine_creizy.CRUD.CComidas"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1">
        <title>CINE CREIZY</title>
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/index.css" type="text/css"><link>
    </head>
    <body>
        <div class="login col-6 col-t-12">
            <h2>Login</h2>
            <br>
            <form name="main" action="Login?accion=login" method="POST">
              <label for="nombre">Nombre de usuario</label>
              <br>
              <input id="nombre" type="text" name="txtUsuario">
              <br><br>
              <label for="nombre">Contraseña</label>
              <br>
              <input id="contra" type="password" name="txtClave">
              <br><br>
              <input id="boton" type="submit" value="Entrar" name="btnEntrar"/>
              <br><br>
            </form>
            <center>
                <c:if test="${error!=null}">
                <c:if test="${error==2}">
                    <p><strong style="color: red">Usuario y/o contraseña incorrectos</strong></p>
                </c:if>
                </c:if>
            </center>
            <br>
            <p>¿no tienes una cuenta?</p>
            <br>
            <a href="Registro.jsp">Registrarse</a>
            <br><p class="punt">.</p>
        </div>
        <%
            CComidas c = new CComidas();
        %>
        
    </body>
</html>
