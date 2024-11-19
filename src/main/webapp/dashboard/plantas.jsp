<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="br.mendonca.testemaven.model.entities.Planta" %>

<!doctype html>
<html lang="pt-br" data-bs-theme="dark">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lista de Plantas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Lista de Plantas</h1>
        <ul class="list-group">
            <%
                List<Planta> plantas = (List<Planta>) request.getAttribute("lista");
                if (plantas != null && !plantas.isEmpty()) {
                    for (Planta planta : plantas) {
            %>
            <!-- Nome Popular como link -->
            <li class="list-group-item">
                <a href="/dashboard/planta-detalhes?uuid=<%= planta.getUuid() %>" class="text-decoration-none">
                    <%= planta.getNomePopular() %>
                </a>
            </li>
            <%
                    }
                } else {
            %>
            <li class="list-group-item text-center">Nenhuma planta cadastrada.</li>
            <%
                }
            %>
        </ul>
        <a href="/dashboard/dashboard.jsp" class="btn btn-secondary mt-4">Voltar ao Dashboard</a>
    </div>
</body>
</html>
