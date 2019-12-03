<%@include file="/restringir.jsp"%>
<form name="borrau" action="Usuario?accion=BorrarUsuario" method="POST">
<div class="usuario">
    <div class="arriba">
        <li>
        <ul class="no"><center>N°</center></ul>
        <ul class="u"><center>Usuario</center></ul>
        <ul class="n"><center>Nombres</center></ul>
        <ul class="e"><center>Email</center></ul>
        <ul class="p"><center>Pais</center></ul>
        <ul class="r"><center>Rol</center></ul>
        <ul class="im"><center>Borrar</center></ul>
    </li>
    </div>
    <br>
    <%int n=0;%>
    <c:forEach var="lista" items="${ListaUsuarios}">
        <br>
        <div class="abajo">
            <li>
            <ul class="no"><center><%=n+1%></center></ul>
            <ul class="u"><center>${lista.getIdusuario()}</center></ul>
            <ul class="n"><center>${lista.getNombres()} ${lista.getApellidos()}</center></ul>
            <ul class="e"><center>${lista.getEmail()}</center></ul>
            <ul class="p"><center>${ListaPaises.get(lista.getIdpais()-1).getPais()}</center></ul>
            <ul class="r"><center>${ListaRoles.get(lista.getIdrol()-1).getRol()}</center></ul>
            <ul class="im"><center><input type="checkbox" name="check" value="${lista.getIdusuario()}"></center></ul>
        </li>
        </div>
        <%n=n+1;%>
    </c:forEach>
</div>
    <div class="col-12 boton">
        <c:if test="${vacio==true}">
            <p><strong style="color: red">Error! ningun usuario seleccionado</strong></p>
            <div style="display: none">${vacio=false}</div>
        </c:if>
        <c:if test="${restriccionU==true}">
            <p><strong style="color: red">No se pudo borrar el usuario ${Usuario} debio a que está en uso, codigo de error #FFFA023</strong></p>
            <div style="display: none">${restriccionU=false}</div>
        </c:if>
        <input type="submit" value="Borrar" name="enviar"/>
    </div>
    
</form>
