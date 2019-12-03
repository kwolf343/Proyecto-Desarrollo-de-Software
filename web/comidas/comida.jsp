<%@include file="/restringir.jsp"%>
<div class="comidas col-12">
    <ul>
        <li class="id"><center>ID</center></li>
        <li class="n"><center>Nombre</center></li>
        <li class="p"><center>Precio</center></li>
        <li class="e"><center>Existencias</center></li>
        <li class="m"><center>Modificar</center></li>
        <li class="b"><center>Borrar</center></li>
    </ul>
    <br>
    <br>
</div>
<div class="datos col-12">
    <c:forEach var="comer" items="${ListaComidas}">
        <ul>
            <li class="id"><center>${comer.getIdcomida()}</center></li>
            <li class="n">${comer.getNombre()}</li>
            <li class="p"><center>$${comer.getPrecio()}</center></li>
            <li class="e"><center>${comer.getExistencia()}</center></li>
            <a href="redirecciona?accion=${2000+comer.getIdcomida()}"><li class="m"><center><img src="imagenes/Modificar.png" width="14%"></center></li></a>
            <a href="redirecciona?accion=${1000+comer.getIdcomida()}"><li class="b"><center><img src="imagenes/Borrar.png" width="14%"></center></li></a>
        </ul>
    </c:forEach>
    <form name="agrega" action="Comida?accion=agregar" method="POST">
        <ul>
            <li class="check1">0</li>
            <li class="check2"><input type="text" name="checkNombre" required></li>
            <li class="check3"><input type="number" step="0.01" name="checkPrecio" required></li>
            <li class="check4"><input type="number" name="checkExistencias" required></li>
            <li class="check5"><input type="submit" value="Agregar" name="enviar2"/></li>
        </ul>
    </form>
</div>
<form class="col-12 formu" name="ventaB" action="${pageContext.servletContext.contextPath}/Reportes?accion=comida" method="POST">
    Reporte Comidas   -    Comida: <input type="text" name="comer" required>
    <input type="submit">
</form>
<c:if test="${nombrecom==true}">
    <p><br><strong style="color: red">Error, la comida que desea agregar, ya se encuentra en el registro</strong></p>
    <div style="display: none">${nombrecom=false}</div>
</c:if>