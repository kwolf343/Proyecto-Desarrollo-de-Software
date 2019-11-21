<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administracion.css" type="text/css"><link>
        <link rel="stylesheet" href="css/AdministrarUsuarios.css" type="text/css"><link>
        <link rel="stylesheet" href="css/venderComida.css" type="text/css"><link>
        <title>Vender Comida</title>
    </head>
    <body>
        <%@include file="/user.jsp"%>
        <div class="col-12 titulo">
            <h2>Vender Comida</h2>
        </div>
        <div class="izquierdo">
            <%@include file="/MenuPrincipal.jsp"%>
        </div>
        <div class="derecho">
            <div class="a">
                <h2>Comidas</h2>
                <div class="col-12 comida">
                    <ul>
                        <li class="c"><center>Comida</center></li>
                        <li class="d"><center>Precio</center></li>
                        <li class="d"><center>Existencias</center></li>
                        <li class="e"><center>Cantidad</center></li>
                        <li class="f"><center>Agregar</center></li>
                    </ul>
                </div>
                <div class="col-12 comida2">
                    <c:forEach var="comer" items="${ListaComidas}">
                        <form name="comp" action="redirecciona?accion=${7000+comer.getIdcomida()}" method="POST">
                        <ul>
                            <li class="c">${comer.getNombre()}</li>
                            <li class="d"><center>$${comer.getPrecio()}</center></li>
                            <li class="d"><center>${comer.getExistencia()}</center></li>
                            <li class="e"><center><input type="number" name="cantidad" min="0" max="${comer.getExistencia()}" required></center></li>
                            <li class="f"><center><input type="submit" value="agregar" name="Comprar"/></center></li>
                        </ul>
                        </form>
                    </c:forEach>
                </div>
            </div>
            <div class="b">
                <h2 style="margin-bottom: 10%;"><center>Ventas</center></h2>
                <c:if test="${MostrarCompra==true}">
                <div id="MostrarOcultar">  
                    <c:if test="${Mostrar==true}">         
                        <c:forEach var="lista" items="${listadodecompra}">
                            <h3>${estaComida.MostrarComidas(lista.getIdcomida()).getNombre()}: ${lista.getCantidadcomida()}</h3><br>
                        </c:forEach>
                    <h3>Total: $${TotalPrecioComida}</h3><br>
                    <h2>${esteid}</h2>
                    <div class="col-12">
                    <center>
                        <form name="comp" action="Ventas?accion=VenderComida" method="POST">
                            <input type="submit" value="Vender" name="Comprar"/>
                        </form>
                    </center>
                    </div>
                    </c:if>
                </div>
                </c:if>
                <div class="contener1">
                    <c:if test="${MostrarCompra!=true}">
                    <div class="col-12">
                    <center>
                        <form name="comp" action="Ventas?accion=IniciarVenta" method="POST">
                            <input type="submit" value="Iniciar venta" name="Comprar"/>
                        </form>
                    </center>
                    </div>
                    </c:if>
                <c:if test="${MostrarCompra==true}">
                <br>
                <div class="col-12">
                    <center>
                        <form name="comp" action="Ventas?accion=CancelarVenta" method="POST">
                            <input type="submit" value="Cancelar venta" name="Comprar"/>
                        </form>
                    </center>
                </div>
                </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
