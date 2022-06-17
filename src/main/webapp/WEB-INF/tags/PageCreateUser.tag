<%@tag description="Onde o cadastro de Usuário é feito" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="usuario" type="model.Usuario"%>

<h2>
    Cadastro de 
    <c:choose>
        <c:when test="${usuario == null}">
            <c:out value="Cliente" />
        </c:when>
        <c:otherwise>
            <c:out value="Usuário" />
        </c:otherwise>
    </c:choose>
</h2>
<form action="createuser" method="POST">
    <p>Preencha os dados:</p>
    <p>CPF</p>
    <input type="text" name="cpf" placeholder="Somente Números" required>
    <p>Nome</p>
    <input type="text"  name="nome" placeholder="Informe o Nome" required>
    <p>Endereço</p>
    <input type="text" name="endereco" placeholder="Informe o Endereço">
    <p>Telefone</p>
    <input type="text" name="telefone" placeholder="Somente Números" required>
    <p>Senha</p>
    <input type="password" name="senha" placeholder="Informe a Senha" required>

    <c:choose>
        <c:when test="${usuario.cliente == false}">
            <p>Tipo de Usuário</p>
            <input type="radio" name="cliente" value="true" required>
            <label>Cliente</label>
            <input type="radio" name="cliente" value="false" required>
            <label>Atendente</label>
        </c:when>
        <c:otherwise>
            <input type="radio" name="cliente" value="true" required checked hidden>
        </c:otherwise>
    </c:choose>

    <input type="submit" value="Enviar">
</form>