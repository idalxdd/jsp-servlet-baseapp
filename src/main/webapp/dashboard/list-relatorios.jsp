<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.mendonca.testemaven.services.dto.RelatorioCrescimentoDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Relatórios de Crescimento</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="../style.css" rel="stylesheet">
</head>
<body class="d-flex align-items-center py-4 bg-body-tertiary">
    <main class="w-100 m-auto form-container">

        <!-- Barra de Navegação -->
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="/dashboard/dashboard.jsp">Gerência de Configuração</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
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

        <h1 class="h3 mb-3 fw-normal">Relatórios de Crescimento</h1>
        <a href="add-relatorio.jsp" class="btn btn-primary mb-3">Adicionar Novo Relatório</a>

        <!-- Tabela de Listagem -->
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Data de Registro</th>
                    <th>Altura (cm)</th>
                    <th>Saúde</th>
                    <th>Observações</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<RelatorioCrescimentoDTO> relatorios = (List<RelatorioCrescimentoDTO>) request.getAttribute("relatorios");
                    if (relatorios != null && !relatorios.isEmpty()) {
                        for (RelatorioCrescimentoDTO relatorio : relatorios) {
                %>
                    <tr>
                        <td><%= relatorio.getId() %></td>
                        <td><%= relatorio.getDataRegistro() %></td>
                        <td><%= relatorio.getAltura() %></td>
                        <td><%= relatorio.getSaude() %></td>
                        <td><%= relatorio.getObservacoes() %></td>
                        <td>
                            <form action="relatorioCrescimento" method="post" style="display:inline;">
                                <input type="hidden" name="id" value="<%= relatorio.getId() %>">
                                <input type="hidden" name="action" value="delete">
                                <button type="submit" class="btn btn-danger btn-sm">Excluir</button>
                            </form>
                        </td>
                    </tr>
                <%
                        }
                    } else { 
                %>
                    <tr>
                        <td colspan="6" class="text-center">Nenhum relatório encontrado.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        

        <!-- Controles de Paginação -->
        <div class="d-flex justify-content-between">
            <%
                int currentPage = (Integer) request.getAttribute("currentPage");
                int totalPages = (Integer) request.getAttribute("totalPages");
            %>

            <% if (currentPage > 1) { %>
                <a href="?page=<%= currentPage - 1 %>" class="btn btn-secondary">Anterior</a>
            <% } else { %>
                <button class="btn btn-secondary" disabled>Anterior</button>
            <% } %>

            <span>Página <%= currentPage %> de <%= totalPages %></span>

            <% if (currentPage < totalPages) { %>
                <a href="?page=<%= currentPage + 1 %>" class="btn btn-secondary">Próxima</a>
            <% } else { %>
                <button class="btn btn-secondary" disabled>Próxima</button>
            <% } %>
        </div>

    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
