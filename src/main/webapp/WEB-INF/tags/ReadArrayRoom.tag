<%@tag description="Lista um Array de Quartos" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<%@attribute name="quartos" type="java.util.ArrayList" %>

<table border="1">
    <thead>
        <tr>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Tipo</th>
            <th>Valor da Diário</th>
            <th>Deletar</th>
            <th>Editar</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="room" items="${quartos}" >
            <tag:ReadRoom room="${room}"/>
        </c:forEach>
    </tbody>
</table>