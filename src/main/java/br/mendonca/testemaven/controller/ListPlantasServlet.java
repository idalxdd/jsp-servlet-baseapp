package br.mendonca.testemaven.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import br.mendonca.testemaven.model.entities.Planta;
import br.mendonca.testemaven.services.PlantaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard/plantas")
public class ListPlantasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Método do GET que lista as plantas
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter page = response.getWriter();

        try {
            // Chama o serviço para listar todas as plantas
            PlantaService service = new PlantaService();
            List<Planta> lista = service.listAllPlantas();

            // Anexa a lista de plantas ao request e redireciona para a JSP
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/dashboard/plantas.jsp").forward(request, response);
        } catch (Exception e) {
            // Captura e exibe erros
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            page.println("<html lang='pt-br'><head><title>Error</title></head><body>");
            page.println("<h1>Error</h1>");
            page.println("<code>" + sw.toString() + "</code>");
            page.println("</body></html>");
            page.close();
        }
    }

    // Método do POST para tratamento de parâmetros (se necessário)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter page = response.getWriter();

        try {
            // Caso precise lidar com parâmetros do POST, implemente aqui
            String parametro = request.getParameter("nomeparametro");
            page.println("Parametro recebido: " + parametro);
        } catch (Exception e) {
            // Captura e exibe erros
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            page.println("<html lang='pt-br'><head><title>Error</title></head><body>");
            page.println("<h1>Error</h1>");
            page.println("<code>");
            page.println(sw.toString());
            page.println("</code>");
            page.println("</body></html>");
        } finally {
            page.close();
        }
    }
}
