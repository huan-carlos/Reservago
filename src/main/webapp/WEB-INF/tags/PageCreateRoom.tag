<%@tag description="Onde o cadastro de Usuário é feito" pageEncoding="UTF-8"%>

<form action="createroom" method="POST">
    <p>Preencha os dados:</p>
    
    <p>Nome</p>
    <input type="text"  name="nome" placeholder="Informe o Nome ..." required>
    
    <p>Descrição</p>
    <input type="text" name="descricao" placeholder="Informe as Características ...">
    
    <p>Valor da Diária</p>
    <input type="number" name="valor_diaria" placeholder="Informe o Valor ..." required>
    
    <p>Tipo do Quarto</p>
    <input type="radio" name="tipo" value="casal" required>
    <label>Casal</label>
    <input type="radio" name="tipo" value="solteiro" required>
    <label>Solteiro</label>
    <input type="radio" name="tipo" value="familia" required>
    <label>Família</label>
    <input type="radio" name="tipo" value="simples" required>
    <label>Simples</label>
    <br>
    <input type="submit" value="Enviar">
</form>