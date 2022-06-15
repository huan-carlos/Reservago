<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel ${initParam.nomeHotel}</title>
    </head>
    <body>
        <h2>Cadastro de Usuário</h2>
        <form action="createuser" method="POST">
            <p>Preencha os dados:</p>
            <p>CPF</p>
<<<<<<< HEAD
            <input type="text" name="cpf" placeholder="Somente Números" required>
            <p>Nome</p>
            <input type="text"  name="nome" placeholder="Informe o Nome" required>
            <p>Endereço</p>
            <input type="text" name="endereco" placeholder="Informe o Endereço">
            <p>Telefone</p>
            <input type="text" name="telefone" placeholder="Somente Números" required>
            <p>Senha</p>
            <input type="password" name="senha" placeholder="Informe a Senha" required>
=======
            <input type="text" placeholder="Somente Números" required>
            <p>Nome</p>
            <input type="text" placeholder="Informe o Nome" required>
            <p>Endereço</p>
            <input type="text" placeholder="Informe o Endereço">
            <p>Telefone</p>
            <input type="text" placeholder="Somente Números" required>
            <p>Senha</p>
            <input type="password" placeholder="Informe a Senha" required>
>>>>>>> 9d86c42de37b3f891783f245126c89687a92b1bc
            <p>Tipo de Usuário</p>
            <input type="radio" name="cliente" value="true" required>
            <label>Cliente</label>
            <input type="radio" name="cliente" value="false" required>
            <label>Atendente</label>
<<<<<<< HEAD
            <input type="submit" value="Enviar">
=======
>>>>>>> 9d86c42de37b3f891783f245126c89687a92b1bc
        </form>
    </body>
</html>
