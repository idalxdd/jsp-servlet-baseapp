<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.mendonca.testemaven.services.dto.UserDTO" %>

<% 
// Verifica se o usuário está logado e se a lista de usuários foi passada
if (session.getAttribute("user") != null && request.getAttribute("lista") != null) {
    UserDTO currentUser = (UserDTO) session.getAttribute("user"); // Usuário logado
    List<UserDTO> lista = (List<UserDTO>) request.getAttribute("lista"); // Lista de usuários
%>

<!doctype html>
<html lang="pt-br" data-bs-theme="dark">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gerência de Configuração - Usuários</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="../style.css" rel="stylesheet">
</head>
<body class="d-flex align-items-center py-4 bg-body-tertiary">

    <main class="w-100 m-auto form-container">

        <!-- Barra de navegação -->
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="/dashboard/dashboard.jsp">Gerência de Configuração</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" 
                    aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link" href="/dashboard/dashboard.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="/dashboard/users">Users</a></li>
						<li class="nav-item"><a class="nav-link" href="/dashboard/add-adocao.jsp">Cadastrar Adoção</a></li>
						<li class="nav-item"><a class="nav-link" href="/dashboard/users">Listar Adoções</a></li>
						<li class="nav-item"><a class="nav-link" href="/dashboard/add-planta.jsp">Cadastrar Planta</a></li>
						<li class="nav-item"><a class="nav-link" href="/dashboard/add-relatorio.jsp">Adicionar Relatório</a></li>
						<li class="nav-item"><a class="nav-link" href="/dashboard/list-relatorios-ocultos.jsp">Ver Relatórios Ocultos</a></li>
						<li class="nav-item"><a class="nav-link" href="/dashboard/plantas">Plantas</a></li>
						<li class="nav-item"><a class="nav-link" href="/dashboard/about.jsp">About</a></li>
                    </ul>
                    <span class="navbar-text">
                        <a class="btn btn-success" href="/auth/logoff">Sair</a>
                    </span>
                </div>
            </div>
        </nav>

        <!-- Título -->
        <h1 class="h3 mb-3 fw-normal">Usuários</h1>

        <!-- Tabela de usuários -->
		<%
		UserDTO currentUser = (UserDTO) session.getAttribute("user");
		if (currentUser == null) {
			response.sendRedirect("/index.jsp");
			return;
		}
		%>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">E-mail</th>
                    <th scope="col">Ações</th>
                </tr>
            </thead>
            <tbody>
				
                <% for (UserDTO user : lista) { 
                    if (!user.getUuid().equals(currentUser.getUuid())) { // Não exibe o usuário logado na lista
                %>
                <tr>
                    <td><%= user.getName() %></td>
                    <td><%= user.getEmail() %></td>
                    <td>
                        <!-- Formulário de seguir ou deixar de seguir -->
                        <form action="/dashboard/follow" method="post" style="display: inline;">
                            <input type="hidden" name="followingUuid" value="<%= user.getUuid() %>" />
                            <% if (request.getAttribute("isFollowing") != null && 
                                   ((List<String>) request.getAttribute("isFollowing")).contains(user.getUuid())) { %>
                                <input type="hidden" name="action" value="unfollow" />
                                <button type="submit" class="btn btn-danger btn-sm">Deixar de Seguir</button>
                            <% } else { %>
                                <input type="hidden" name="action" value="follow" />
                                <button type="submit" class="btn btn-primary btn-sm">Seguir</button>
                            <% } %>
                        </form>
                    </td>
                </tr>
                <% } } %>
            </tbody>
        </table>

    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

<% } %>
