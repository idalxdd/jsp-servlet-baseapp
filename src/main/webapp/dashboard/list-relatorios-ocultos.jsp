<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.mendonca.testemaven.services.dto.RelatorioCrescimentoDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Relatórios Ocultos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="../style.css" rel="stylesheet">
</head>
<body class="d-flex align-items-center py-4 bg-body-tertiary">
    <main class="w-100 m-auto form-container">

        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="/dashboard/dashboard.jsp">Gerência de Configuração</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link" href="/dashboard/dashboard.jsp">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="/relatorioCrescimento?action=ocultos">Relatórios Ocultos</a></li>
                    </ul>
                    <span class="navbar-text">
                        <a class="btn btn-success" href="/auth/logoff">Sair</a>
                    </span>
                </div>
            </div>
        </nav>

        <h1 class="h3 mb-3 fw-normal">Relatórios Ocultos</h1>

        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Data de Registro</th>
                    <th>Altura (cm)</th>
                    <th>Saúde</th>
                    <th>Observações</th>
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
                    </tr>
                <%
                        }
                    } else { 
                %>
                    <tr>
                        <td colspan="5" class="text-center">Nenhum relatório oculto encontrado.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>