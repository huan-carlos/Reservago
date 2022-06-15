<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel ${initParam.nomeHotel} | Login</title>
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
    </body>
</html>
