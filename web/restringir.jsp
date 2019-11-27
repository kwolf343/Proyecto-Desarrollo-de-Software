<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${Rol==2}">
    <%
        request.getRequestDispatcher("/Administrar.jsp").forward(request, response);
    %>
</c:if>