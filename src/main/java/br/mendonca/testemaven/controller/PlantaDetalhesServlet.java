package br.mendonca.testemaven.controller;

import java.io.IOException;
import br.mendonca.testemaven.model.entities.Planta;
import br.mendonca.testemaven.services.PlantaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard/planta-detalhes")
public class PlantaDetalhesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String uuid = request.getParameter("uuid");

        try {
            // Obter os detalhes da planta pelo UUID
            PlantaService service = new PlantaService();
            Planta planta = service.search(uuid);

            if (planta != null) {
                // Redireciona os detalhes para uma página JSP
                request.setAttribute("planta", planta);
                request.getRequestDispatcher("planta-detalhes.jsp").forward(request, response);
            } else {
                response.getWriter().println("<h1>Planta não encontrada!</h1>");
            }
        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
        }
    }
}
