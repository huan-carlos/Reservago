<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.nomeHotel} | Cadastrar Quarto</title>
    </head>
    <body>
        <h2>Cadastro de Quarto</h2>
        <tag:PageCreateRoom usuario="${sessionScope.usuario}"/>
    </body>
</html>
