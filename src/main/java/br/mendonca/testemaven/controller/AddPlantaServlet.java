package br.mendonca.testemaven.controller;

import java.io.IOException;
import br.mendonca.testemaven.services.PlantaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard/add-planta")
public class AddPlantaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nomeCientifico = request.getParameter("nomeCientifico");
            String nomePopular = request.getParameter("nomePopular");
            String origem = request.getParameter("origem");

            PlantaService plantaService = new PlantaService();
            plantaService.register(nomeCientifico, nomePopular, origem);

            response.sendRedirect("/dashboard/dashboard.jsp?success=true");
        } catch (Exception e) {
            response.sendRedirect("/dashboard/dashboard.jsp?error=true");
        }
    }
}