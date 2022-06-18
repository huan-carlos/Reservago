<%@tag description="Lista um usuario" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="room" type="model.Quarto" %>
<tr>
    <td>${room.nome}</td>
    <td>${room.descricao}</td>
    <td>${room.tipo}</td>
    <td>${room.valor_diaria}</td>
    <td><a href="deleteroom?nome=${room.nome}">Deletar</a></td>
    <td><a href="updateroom?nome=${room.nome}">Editar</a></td>
</tr>
