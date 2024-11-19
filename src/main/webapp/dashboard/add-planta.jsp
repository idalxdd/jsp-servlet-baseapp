<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br" data-bs-theme="dark">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastrar Planta</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <h1>Cadastrar Nova Planta</h1>
        <form action="/dashboard/add-planta" method="post">
		    <div class="mb-3">
		        <label for="nomeCientifico" class="form-label">Nome Científico</label>
		        <input type="text" class="form-control" id="nomeCientifico" name="nomeCientifico" required>
		    </div>
		    <div class="mb-3">
		        <label for="nomePopular" class="form-label">Nome Popular</label>
		        <input type="text" class="form-control" id="nomePopular" name="nomePopular" required>
		    </div>
		    <div class="mb-3">
		        <label for="origem" class="form-label">Origem</label>
		        <input type="text" class="form-control" id="origem" name="origem" required>
		    </div>
		    <button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
    </div>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
