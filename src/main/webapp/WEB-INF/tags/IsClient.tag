<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="usuario" type="model.Usuario"%>

<c:choose>
    <c:when test="${usuario == null}">
        <c:out value="Cliente" />
    </c:when>
    <c:otherwise>
        <c:out value="Usuário" />
    </c:otherwise>
</c:choose>