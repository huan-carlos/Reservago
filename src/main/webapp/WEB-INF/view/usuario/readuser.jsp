<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuários | Hotel ${initParam.nomeHotel}</title>
    </head>
    <body>
        <h2>Listagem de Usuários</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>CPF</th>
                    <th>Nome</th>
                    <th>Endereço</th>
                    <th>Telefone</th>
                    <th>Senha</th>
                    <th>Tipo</th>
                    <th>Editar</th>
                    <th>Deletar</th>
                </tr>
            </thead>
            <tbody>
                <tag:ReadArrayUsers usuarios="${sessionScope.usuarios}" />
            </tbody>
        </table>

    </body>
</html>
