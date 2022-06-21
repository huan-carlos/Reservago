<%@tag description="Lista um Array de Quartos" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<%@attribute name="quartos" type="java.util.ArrayList" %>
<%@attribute name="usuario" type="model.Usuario"%>

<table border="1">
    <thead>
        <tr>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Tipo</th>
            <th>Valor da Diário</th>
            <c:choose>
                <c:when test="${usuario.cliente}">
                    <th>Reserva</th>
                </c:when>
                <c:otherwise>
                    <th>Deletar</th>
                    <th>Editar</th>
                    <th>Reserva</th>
                </c:otherwise>
            </c:choose>

        </tr>
    </thead>
    <tbody>
        <c:forEach var="room" items="${quartos}" >
            <tag:ReadRoom usuario="${usuario}" room="${room}"/>
        </c:forEach>
    </tbody>
</table>