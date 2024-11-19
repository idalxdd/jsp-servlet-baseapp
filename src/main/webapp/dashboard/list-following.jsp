<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.mendonca.testemaven.services.dto.UserDTO" %>

<% 
if (session.getAttribute("user") != null && request.getAttribute("following") != null) {
    List<UserDTO> following = (List<UserDTO>) request.getAttribute("following"); // Lista de usuários que o atual segue
%>

<!doctype html>
<html lang="pt-br" data-bs-theme="dark">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Usuários Seguidos</title>
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
                        <li class="nav-item"><a class="nav-link" href="/dashboard/users">Usuários</a></li>
                        <li class="nav-item"><a class="nav-link" href="/dashboard/about.jsp">Sobre</a></li>
                    </ul>
                    <span class="navbar-text">
                        <a class="btn btn-success" href="/auth/logoff">Sair</a>
                    </span>
                </div>
            </div>
        </nav>
        <!-- Título -->
        <h1 class="h3 mb-3 fw-normal">Usuários que você segue</h1>

        <!-- Tabela de usuários seguidos -->
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">E-mail</th>
                </tr>
            </thead>
            <tbody>
                <% 
                if (following != null && !following.isEmpty()) {
                    for (UserDTO user : following) {
                %>
                <tr>
                    <td><%= user.getName() %></td>
                    <td><%= user.getEmail() %></td>
                </tr>
                <% 
                    }
                } else { 
                %>
                <tr>
                    <td colspan="2" class="text-center">Você ainda não segue ninguém.</td>
                </tr>
                <% } %>
            </tbody>
        </table>

    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

<% } %>
