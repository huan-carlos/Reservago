<%@tag description="Lista apenas um lembrete" pageEncoding="UTF-8"%>
<%@attribute name="usuario" type="model.Usuario" %>
<tr>
    <td>${usuario.cpf}</td>
    <td>${usuario.nome}</td>
    <td>${usuario.endereco}</td>
    <td>${usuario.telefone}</td>
    <td>${usuario.senha}</td>
    <td>${usuario.tipo}</td>
    <td><a href="deleteuser?cpf=${usuario.cpf}">Deletar</a></td>
    <td><a href="editarlembrete?codigo=${lembrete.codigo}&flag=1">Editar</a></td>
</tr>
