<%@tag description="Onde o cadastro de Usuário é editado" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="quarto" type="model.Quarto"%>

<form action="updateroom" method="POST">
    <p>Preencha os dados:</p>
    <p>Nome</p>
    <input type="text"  name="nome" placeholder="Informe o Nome ..." value="${quarto.nome}" readonly>
    <p>Descrição</p>
    <input type="text" name="descricao" placeholder="Informe a Descrição ..." value="${quarto.descricao}" required>
    <p>Valor da Diária</p>
    <input type="text" name="valor_diaria" placeholder="Informe a Diária .." value="${quarto.valor_diaria}" required>

    <p>Tipo de Quarto</p>
    <input type="text" name="tipo" value="${quarto.tipo}" required>
    <p></p>
    <input type="submit" value="Enviar">
</form>