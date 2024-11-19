<h2>Usuários Seguidos</h2>
<table>
    <thead>
        <tr>
            <th>Nome</th>
            <th>Email</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${usuariosSeguidos}">
            <tr>
                <td>${user.nome}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
