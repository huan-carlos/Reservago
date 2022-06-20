<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.nomeHotel} | Editar Quarto</title>
    </head>
    <body>
        <h2>Edição de Quarto</h2>
        <tag:PageUpdateRoom quarto="${sessionScope.roomToUpdate}" />
    </body>
</html>
