<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.nomeHotel} | Editar Usuário</title>
    </head>
    <body>
        <h2>Edição de Usuário</h2>
        <tag:PageUpdateUser usuario="${sessionScope.userToUpdate}" />
    </body>
</html>
