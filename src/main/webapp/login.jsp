<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="main.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.nomeHotel} | Página de Login</title>
    </head>
    <body>
        <h2>Página de Login</h2>
        <p>Preencha os dados solicitados:</p>
        <form action="logar" method="POST">
            <p>CPF</p>
            <input type="number" name="cpf" placeholder="Somente Números">
            <p>Senha</p>
            <input type="password" name="senha" placeholder="Informe a Senha">
            <p></p>
            <input type="submit" value="Logar">
        </form>
        <div class="mensagem">${param.mensagem}</div>
    </body>
</html>
