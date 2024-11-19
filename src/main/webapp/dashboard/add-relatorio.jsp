<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Adicionar Relatório de Crescimento</title>
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
                        <li class="nav-item"><a class="nav-link" href="/dashboard/users">Usuários</a></li>
                        <li class="nav-item"><a class="nav-link" href="/relatorioCrescimento">Relatórios de Crescimento</a></li>
                    </ul>
                    <span class="navbar-text">
                        <a class="btn btn-success" href="/auth/logoff">Logoff</a>
                    </span>
                </div>
            </div>
        </nav>

        <h1 class="h3 mb-3 fw-normal">Adicionar Relatório de Crescimento</h1>
        
        <!-- Formulário para adicionar relatório -->
        <form action="/relatorioCrescimento" method="post">
            <div class="form-floating mb-3">
                <input type="number" id="dataRegistro" name="dataRegistro" class="form-control" placeholder="Data de Registro (AAAAMMDD)" required>
                <label for="dataRegistro">Data de Registro (formato AAAAMMDD)</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" id="altura" name="altura" class="form-control" placeholder="Altura (em cm)" step="0.01" required>
                <label for="altura">Altura (em cm)</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" id="saude" name="saude" class="form-control" placeholder="Saúde da Planta" required>
                <label for="saude">Saúde da Planta</label>
            </div>
            <div class="form-floating mb-3">
                <textarea id="observacoes" name="observacoes" class="form-control" placeholder="Observações"></textarea>
                <label for="observacoes">Observações</label>
            </div>
            <button type="submit" class="btn btn-primary w-100 py-2 mt-2">Adicionar Relatório</button>
        </form>

    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
