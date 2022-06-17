<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.nomeHotel} | Cadastrar Usuário</title>
    </head>
    <body>
        <tag:PageCreateUser usuario="${sessionScope.usuario}"/>
    </body>
</html>
