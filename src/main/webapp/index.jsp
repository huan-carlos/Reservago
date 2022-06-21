<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="index.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.nomeHotel} | Página Inicial</title>
    </head>
    <body>
        <header>
            <nav>
                <a href="login.jsp">Logar</a>
                <a href="createuser?flag=1">Cadastrar</a>
            </nav>
        </header>
        <main>
            <c:forEach var="room" items="${applicationScope.quartos}">
                <tag:IndexRoom quarto="${room}" />
            </c:forEach>
        </main>
    </body>
</html>
