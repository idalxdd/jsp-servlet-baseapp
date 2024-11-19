<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Adicionar uma Adoção</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="../style.css" rel="stylesheet">
</head>
<body class="d-flex flex-column min-vh-100 bg-body-tertiary">
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
                    <li class="nav-item"><a class="nav-link" href="/dashboard/add-adocao.jsp">Cadastro de Adoção</a></li>
                </ul>
                <span class="navbar-text">
                    <a class="btn btn-success" href="/auth/logoff">Logoff</a>
                </span>
            </div>
        </div>
    </nav>

    <!-- Conteúdo principal -->
    <main class="container my-5">
        <div class="card shadow">
            <div class="card-body">
                <h1 class="h3 mb-4 fw-bold text-center">Adicionar Adoção</h1>
                <form action="/cadastroAdocao" method="post">
                    <div class="form-floating mb-3">
                        <input type="text" id="usuarioId" name="usuarioId" class="form-control" placeholder="Id do usuário" required>
                        <label for="usuarioId">Id do usuário</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" id="plantaId" name="plantaId" class="form-control" placeholder="Id da planta" required>
                        <label for="plantaId">Id da planta</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="date" id="dataAdocao" name="dataAdocao" class="form-control" placeholder="Data" required>
                        <label for="dataAdocao">Data de Adoção</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" id="statusAdocao" name="statusAdocao" class="form-control" placeholder="Status" required>
                        <label for="statusAdocao">Status</label>
                    </div>
                    <div class="form-floating mb-3">
                        <textarea id="lembreteAdocao" name="lembreteAdocao" class="form-control" placeholder="Lembrete" rows="3" style="height: 100px;" required></textarea>
                        <label for="lembreteAdocao">Lembrete</label>
                    </div>
                    <button type="submit" class="btn btn-primary w-100 py-2">Cadastrar Adoção</button>
                </form>
            </div>
        </div>
    </main>

    <footer class="mt-auto bg-dark text-center text-light py-3">
        <p>&copy; 2024 Gerência de Configuração. Todos os direitos reservados.</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

