<%@include file="/restringir.jsp"%>
<div class="uno">
    <ul>
    <li class="i"><center>Id</center></li>
    <li class="f"><center>Formato</center></li>
    <li class="t"><center>Tipo</center></li>
    <li class="p"><center>Precio</center></li>
    <li class="m"><center>Modificar</center></li>
    <li class="b"><center>Borrar</center></li>
</ul>
</div>
<br><br>
<div class="dos">
    <c:forEach var="TipoBoletos" items="${ListaTipodeBoletos}">
        <ul>
            <li class="i"><center>${TipoBoletos.getIdtipodeboleto()}</center></li>
            <li class="f"><center>${TipoBoletos.getFormato()}</center></li>
            <li class="t"><center>${TipoBoletos.getTipo()}</center></li>
            <li class="p"><center>$${TipoBoletos.getPrecio()}</center></li>
            <a href="redirecciona?accion=${4000+TipoBoletos.getIdtipodeboleto()}"><li class="m"><center><img src="imagenes/Modificar.png" width="14%"></center></li></a>
            <a href="redirecciona?accion=${5000+TipoBoletos.getIdtipodeboleto()}"><li class="b"><center><img src="imagenes/Borrar.png" width="14%"></center></li></a> 
    </c:forEach>
</div>
    <div class="tres col-12">
    <form name="bol" action="Boleto?accion=AgregaBoleto" method="POST">
        <ul>
        <li class="idB">a</li>
        <li class="f"><input type="text" name="formato" required></li>
        <li class="t"><input type="text" name="tipo" required></li>
        <li class="p"><input type="number" step="0.01" name="precio" required></li>
        <li class="btn"><input type="submit" value="Agregar" name="enviar"/></li>
    </ul>
    </form>
</div>
<div>
    <c:if test="${tipo123==true}">
        <p><br><strong style="color: red">Error de inserción, Tipo de boleto ya existente</strong></p>
        <div style="display: none">${tipo123=false}</div>
    </c:if>
</div>