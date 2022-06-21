<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="main.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.nomeHotel} | Cadastro de Reserva</title>
    </head>
    <body>
        <h2>Cadastro de Reserva</h2>
        <p>Preencha todos os dados</p>
        <form action="createbooking" method="POST">
            <c:choose>
                <c:when test="${sessionScope.usuario.cliente}">
                    <p>CPF do Cliente</p>
                    <input type="text" name="usuario_cpf" value="${sessionScope.usuario.cpf}" readonly/>
                </c:when>
                <c:otherwise>
                    <p>CPF do Cliente</p>
                    <input type="text" name="usuario_cpf""/>
                </c:otherwise>
            </c:choose>
            <p>Nome Quarto</p>
            <input type="text" name="quarto_nome" value="${sessionScope.RoomToBooking.nome}" readonly/>
            <p>Descrição</p>
            <input type="text" value="${sessionScope.RoomToBooking.descricao}" readonly/>
            <p>Tipo</p>
            <input type="text" value="${sessionScope.RoomToBooking.tipo}" readonly/>
            <p>Valor Diária</p>
            <input type="text" value="${sessionScope.RoomToBooking.valor_diaria}" readonly/>
            <p>Data Início</p>
            <input type="date" name="inicio" />
            <p>Data Fim</p>
            <input type="date" name="fim" /><br><br>
            <input type="submit" value="Reservar" />
        </form>
    </body>
</html>
