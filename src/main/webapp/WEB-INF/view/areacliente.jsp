<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="main.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.nomeHotel} | Área do Cliente</title>
    </head>
    <body>
        <header>
            <h2>Menú do Cliente</h2>
            <nav>
                <a href="createbooking">| Criar uma Reserva |</a>
                <a href="sair">Sair |</a>
            </nav>
        </header>
        <main>
            <article>
                <p>Lista de Reservas</p>
                <tag:ReadArrayBooking usuario="${sessionScope.use}" reservas="${sessionScope.bookingUser}"/>
                <p></p>
                <div class="mensagem">${param.mensagem}</div>
            </article>
        </main>
    </body>
</html>
