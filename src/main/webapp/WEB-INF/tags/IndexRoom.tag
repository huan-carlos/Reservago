<%@tag description="Mostra os Quartos na home do site" pageEncoding="UTF-8"%>
<%@attribute name="quarto" type="model.Quarto"%>

<img src="img/1.jpg" height="200px" alt="Foto do Quarto"/>
<table>
    <thead>
        <tr>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Tipo</th>
            <th>Valor Diária</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>${quarto.nome}</td>
            <td>${quarto.descricao}</td>
            <td>${quarto.tipo}</td>
            <td><form action="login.jsp"><input type="submit" value="Fazer Login" /></form></td>
        </tr>
    </tbody>
</table>