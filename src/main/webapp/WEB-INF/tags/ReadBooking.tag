<%@tag description="Lista um usuario" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="booking" type="model.Reserva" %>
<%@attribute name="usuario" type="model.Usuario" %>
<tr>
    <c:if test="${usuario.cliente == false}">
        <th>${booking.usuario.cpf}</th>
    </c:if>
    <td>${booking.id_reserva}</td>
    <td>${booking.quarto.nome}</td>
    <td>${booking.inicio}</td>
    <td>${booking.fim}</td>
    <td><a href="deletebooking?id_reserva=${booking.id_reserva}">Deletar</a></td>
    <td><a href="updatebooking?id_reserva=${booking.id_reserva}">Editar</a></td>
</tr>
