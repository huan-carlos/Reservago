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
                <a href=""></a>
            </nav>
        </header>
        <main>
            <article>
                <tag:ReadArrayRoom quartos="${sessionScope.quartos}" />
            </article>
        </main>
    </body>
</html>
