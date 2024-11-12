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
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter page = response.getWriter();
        String msg = "<h1>Install Database</h1>";

        try {
            InstallService service = new InstallService();

            // Testa a conexão com o banco de dados
            service.testConnection();
            msg += "<h2>Connection to DB successful!</h2>";

            // Obtém o parâmetro "table" para saber qual tabela criar
            String table = request.getParameter("table");

            if (table == null) {
                msg += "<h3>Use '?table=users' ou '?table=relatorios' na URL.</h3>";
            } else {
                switch (table) {
                    case "users":
                        service.createUserTable();
                        msg += "<h2>User table created successfully!</h2>";
                        break;
                    case "relatorios":
                        service.createRelatorioTable();
                        msg += "<h2>Relatorio de Crescimento table created successfully!</h2>";
                        break;
                    default:
                        msg += "<h3>Table '" + table + "' is not recognized. Available options: 'users', 'relatorios'.</h3>";
                }
            }

            page.println("<html lang='pt-br'><head><title>Install Tables</title></head><body>");
            page.println(msg);
            page.println("</body></html>");
            page.close();

        } catch (Exception e) {
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
