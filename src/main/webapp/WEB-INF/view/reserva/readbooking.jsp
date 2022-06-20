<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.nomeHotel} | Listar Reservas</title>
    </head>
    <body>
        <h2>Reservas Cadastrados</h2>
        <tag:ReadArrayBooking usuario="${sessionScope.use}" reservas="${sessionScope.allBookings}"/>
    </body>
</html>
