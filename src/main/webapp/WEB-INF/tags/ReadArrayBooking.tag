<%@tag description="Lista um Array de Reservas" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<%@attribute name="reservas" type="java.util.ArrayList" %>
<%@attribute name="usuario" type="model.Usuario" %>

<table border="1">
    <thead>
        <tr>

            <c:if test="${usuario.cliente == false}">
                <th>CPF</th>
            </c:if>
            <th>ID Reserva</th>
            <th>Nome do Quarto</th>
            <th>Início</th>
            <th>Fim</th>
            <th>Deletar</th>
            <th>Editar</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="booking" items="${reservas}" >
            <tag:ReadBooking usuario="${usuario}" booking="${booking}"/>
        </c:forEach>
    </tbody>
</table>