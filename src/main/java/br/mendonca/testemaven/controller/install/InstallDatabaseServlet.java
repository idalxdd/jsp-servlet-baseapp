package br.mendonca.testemaven.controller.install;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import br.mendonca.testemaven.services.InstallService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/install")
public class InstallDatabaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter page = response.getWriter();

        try {
            InstallService service = new InstallService();
            String msg = "<h1>INSTALL DATABASE</h1>";

            // Testa a conexão com o banco de dados
            service.testConnection();
            msg += "<h2>Connection to DB successful!</h2>\n";

            // Obtém o parâmetro "table" para saber qual tabela criar
            String table = request.getParameter("table");

            if (table == null) {
                msg += "<h3>Use '?table=users' ou '?table=plantas' na URL.</h3>";
            } else {
                switch (table) {
                    case "users":
                        service.createUserTable();
                        msg += "<h2>User table created successfully!</h2>\n";
                        break;
                    case "plantas":
                        service.createPlantaTable();
                        msg += "<h2>Planta table created successfully!</h2>\n";
                        break;
                    default:
                        msg += "<h3>Table '" + table + "' is not recognized. Available options: 'users' or 'plantas'.</h3>";
                }
            }

            page.println("<html lang='pt-br'><head><title>Install Tables</title></head><body>");
            page.println(msg);
            page.println("</body></html>");
            page.close();

        } catch (Exception e) {
            // Exibe mensagens de erro em uma página de resposta
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            page.println("<html lang='pt-br'><head><title>Error</title></head><body>");
            page.println("<h1>Error</h1>");
            page.println("<code>");
            page.println(sw.toString());
            page.println("</code>");
            page.println("</body></html>");
            page.close();
        }
    }
}
