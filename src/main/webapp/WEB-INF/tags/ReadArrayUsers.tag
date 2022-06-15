<%@tag description="Lista um Array de lembretes" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<%@attribute name="lembretes" type="java.util.ArrayList" %>

<c:forEach var="lembrete" items="${lembretes}" >
    <tag:ListarLembrete lembrete="${lembrete}"/>
</c:forEach>