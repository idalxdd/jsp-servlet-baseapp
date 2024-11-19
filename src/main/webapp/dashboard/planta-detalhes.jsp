<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.mendonca.testemaven.model.entities.Planta" %>

<!doctype html>
<html lang="pt-br" data-bs-theme="dark">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Detalhes da Planta</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Detalhes da Planta</h1>
        <%
            Planta planta = (Planta) request.getAttribute("planta");
            if (planta != null) {
        %>
        <p><strong>Nome Científico:</strong> <%= planta.getNomeCientifico() %></p>
        <p><strong>Nome Popular:</strong> <%= planta.getNomePopular() %></p>
        <p><strong>Origem:</strong> <%= planta.getOrigem() %></p>
        <%
            } else {
        %>
        <p>Planta não encontrada.</p>
        <%
            }
        %>
        <a href="/dashboard/plantas" class="btn btn-primary">Voltar à Lista</a>
    </div>
</body>
</html>
