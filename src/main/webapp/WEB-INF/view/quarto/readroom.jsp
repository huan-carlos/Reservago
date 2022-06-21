<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.nomeHotel} | Listar Quartos</title>
    </head>
    <body>
        <h2>Lista de Quartos</h2>
        <tag:ReadArrayRoom usuario="${sessionScope.usuario}" quartos="${sessionScope.quartos}" />
    </body>
</html>
