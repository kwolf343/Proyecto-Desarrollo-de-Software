<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% HttpSession sesion = request.getSession();
        if(sesion.getAttribute("Usuario")==null){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Cache-Control","no-store");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires",0);
        %>
<div class="MP">
    <c:forEach var="menu" items="${MenuPrincipal}">
        <li><h2><a href="${pageContext.servletContext.contextPath}${menu.url}?op=${menu.idmenu}">${menu.menu}</a></h2></li>
    </c:forEach>
</div>
