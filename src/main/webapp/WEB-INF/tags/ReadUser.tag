<%@tag description="Lista um usuario" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="usuario" type="model.Usuario" %>
<tr>
    <td>${usuario.cpf}</td>
    <td>${usuario.nome}</td>
    <td>${usuario.endereco}</td>
    <td>${usuario.telefone}</td>
    <td>${usuario.senha}</td>
    <td>
        <c:choose>
            <c:when test="${usuario.cliente == true}">
                <c:out value="Cliente" />
            </c:when>
            <c:otherwise>
                <c:out value="Atendente" />
            </c:otherwise>
        </c:choose>
    </td>
    <td><a href="deleteuser?cpf=${usuario.cpf}">Deletar</a></td>
    <td><a href="editarlembrete?codigo=${usuario}&flag=1">Editar</a></td>
</tr>
