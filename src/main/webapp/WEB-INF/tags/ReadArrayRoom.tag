<%@tag description="Lista um Array de Usuarios" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<%@attribute name="usuarios" type="java.util.ArrayList" %>

<c:forEach var="user" items="${usuarios}" >
    <tag:ReadUser usuario="${user}"/>
</c:forEach>