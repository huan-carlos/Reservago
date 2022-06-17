<%@tag description="Onde o cadastro de Usuário é editado" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="usuario" type="model.Usuario"%>

<form action="updateuser" method="POST">
    <p>Preencha os dados:</p>
    <p>CPF</p>
    <input type="text" name="cpf" placeholder="Somente Números" value="${usuario.cpf}" readonly>
    <p>Nome</p>
    <input type="text"  name="nome" placeholder="Informe o Nome" value="${usuario.nome}" required>
    <p>Endereço</p>
    <input type="text" name="endereco" placeholder="Informe o Endereço" value="${usuario.endereco}">
    <p>Telefone</p>
    <input type="text" name="telefone" placeholder="Somente Números" value="${usuario.telefone}" required>
    <p>Senha</p>
    <input type="password" name="senha" placeholder="Informe a Senha" value="${usuario.senha}" required>

    <p>Tipo de Usuário</p>
    <c:choose>
        <c:when test="${usuario.cliente == true}">
            <input type="radio" name="cliente" value="true" required checked>
            <label>Cliente</label>
            <input type="radio" name="cliente" value="false" required>
            <label>Atendente</label>
        </c:when>
        <c:otherwise>
            <input type="radio" name="cliente" value="true" required>
            <label>Cliente</label>
            <input type="radio" name="cliente" value="false" required checked>
            <label>Atendente</label>
        </c:otherwise>
    </c:choose>

    <input type="submit" value="Enviar">
</form>