<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.nomeHotel} | Área do Cliente</title>
    </head>
    <body>
        <header>
            <h2>Menú do Cliente</h2>
            <nav>
                <a href="sair">| Sair |</a>
            </nav>
        </header>
        <main>
            <article>
                <p>Lista de Reservas</p>
                <tag:ReadArrayBooking usuario="${sessionScope.use}" reservas="${sessionScope.bookingUser}"/>
            </article>
        </main>
    </body>
</html>
