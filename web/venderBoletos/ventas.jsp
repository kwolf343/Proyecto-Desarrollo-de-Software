<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
        <link rel="stylesheet" href="css/Administracion.css" type="text/css"><link>
        <link rel="stylesheet" href="css/venderBoletos.css" type="text/css"><link>
        <title>Vender Boletos</title>
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
                <c:if test="${HoraBoletos!=true}">
                <div class="col-12 uno">
                    <div class="col-12 f1">
                        <h1>Paso 1</h1><br><br>
                        <h2>Horarios</h2><br><br>
                        <c:forEach var="i" items="${ListadoPrueba}">
                            <h3>${estaPelicula.MostrarPelicula(i[0].getIdpelicula()).getTitulo()}</h3>
                            <c:forEach var="item2" items="${i}">
                                <form name="comp" action="redirecciona?accion=${8000+item2.getIdproyeccion()}" method="POST">
                                    <input type="submit" value="${item2.getHorainicio()}" name="v1"/>
                                </form>
                            </c:forEach>
                            <br><br>
                        </c:forEach>
                    </div>
                </div>
                </c:if>
                <c:if test="${TBoletos==true}">
                    <div class="col-12 dos">
                    <div class="col-12 f2">
                        <h1>Paso 2</h1><br><br>
                        <div class="temas">
                            <h2 class="h2">Boletos</h2><h3 class="h22">Pelicula: ${estaPelicula.MostrarPelicula(estaProyeccion.MostrarProyecciones(IdBoleto).getIdpelicula()).getTitulo()}</h3><h3> Horario: ${estaProyeccion.MostrarProyecciones(IdBoleto).getHorainicio()}</h3>
                        </div>
                        <br><br>
                        <div class="arriba">
                            <ul class="ar">
                                <li class="bol"><center>Boletos</center></li>
                                <li class="pre"><center>Precio</center></li>
                                <li class="cant"><center>Cantidad</center></li>
                                <li class="add"><center>Agregar</center></li>
                            </ul>
                            <div class="abajo">
                                <ul>
                                    <c:forEach var="i" items="${ListaTipodeBoletos}"> 
                                        <form class="blanco" name="ventaB" action="VentasBoletos?accion=hola" method="POST">
                                            <li class="bol">${i.getFormato()}       ${i.getTipo()}</li>
                                            <li class="pre"><center>$${i.getPrecio()}</center></li>
                                            <li class="cant"><center><input type="number" name="cantidad" min="1" required></center></li>
                                            <li class="add"><center><input type="submit" value="agregar" name="Comprar"/></center></li>
                                        </form>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div>
                        </div>
                        <div class="botones">
                            <form class="cance" name="ve11" action="VentasBoletos?accion=cancelar" method="POST">
                                <input type="submit" value="Cancelar" name="Cancelar"/>
                            </form>
                            <form class="cance" name="ve12" action="VentasBoletos?accion=siguiente" method="POST">
                                <input type="submit" value="Siguiente" name="Siguiente"/>
                            </form>
                        </div>
                    </div>
                    </div>
                </c:if>
                <c:if test="${ABoletos==true}">
                    <div class="col-12 tres">
                        <div class="col-12 f3">
                            <h1>Paso 3</h1><br><br>
                            <h2>Asientos</h2><br><br>
                            <div class="col-12">
                                
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="b color2">bb</div>
        </div>
    </body>
</html>
