<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel ${initParam.nomeHotel} | Login</title>
    </head>
    <body>
<<<<<<< HEAD
        <h2>Página de Login</h2>
        <p>Preencha os dados solicitados:</p>
        <form action="logar" method="POST">
            <p>CPF</p>
            <input type="number" name="cpf" placeholder="Somente Números">
            <p>Senha</p>
            <input type="password" name="senha" placeholder="Informe a Senha">
=======
        <p>${request.getParameter("mensagem")}</p>
        <h2>Página de Login</h2>
        <p>Preencha os dados solicitados:</p>
        <form action="login" method="POST">
            <p>CPF</p>
            <input type="number" placeholder="Somente Números">
            <p>Senha</p>
            <input type="password" placeholder="Informe a Senha">
>>>>>>> 9d86c42de37b3f891783f245126c89687a92b1bc
            <p></p>
            <input type="submit" value="Logar">
        </form>
    </body>
</html>
