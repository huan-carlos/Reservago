<%@tag description="Lista um usuario" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="room" type="model.Quarto" %>
<%@attribute name="usuario" type="model.Usuario"%>
<tr>
    <td>${room.nome}</td>
    <td>${room.descricao}</td>
    <td>${room.tipo}</td>
    <td>${room.valor_diaria}</td>

    <c:choose>
        <c:when test="${usuario.cliente}">
                <td><a href="createbooking?nome=${room.nome}&flag=1">Reservar</a></td>
            </c:when>
            <c:otherwise>
                <td><a href="deleteroom?nome=${room.nome}">Deletar</a></td>
                <td><a href="updateroom?nome=${room.nome}">Editar</a></td>
                <td><a href="createbooking?nome=${room.nome}&flag=1">Reservar</a></td>
        </c:otherwise>
    </c:choose>


</tr>
