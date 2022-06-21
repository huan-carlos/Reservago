<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.nomeHotel} | Área do Atendente</title>
    </head>
    <body>
        <h2>Menú do Atendente</h2>
        <nav>
            <a href="createuser?flag=1">| Criar Usuário |</a>
            <a href="readuser">Listar Usuários |</a>
            <a href="createroom?flag=1">| Criar Quarto |</a>
            <a href="readroom">Listar Quartos |</a>
            <a href="readbooking">Listar Reserva |</a>
            <a href="sair">Sair |</a>
        </nav>
    </body>
</html>
