package br.mendonca.testemaven.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/install")
public class Install extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter page = response.getWriter();
		
		try {
			Map<String, String> env = System.getenv();
			
			String DB_HOST = env.get("DB_HOST");
			String DB_PORT = env.get("DB_PORT");
			String DB_NAME = env.get("DB_NAME");
			String DB_USER = env.get("DB_USER");
			String DB_PASS = env.get("DB_PASS");
			
			Class.forName("org.postgresql.Driver");
			DriverManager.getConnection("jdbc:postgresql://" + DB_HOST+ ":" + DB_PORT + "/" + DB_NAME, DB_USER, DB_PASS);
			
			page.println("<html lang='pt-br'><head><title>Exemplo</title></head><body>");
			page.println("<h1>OK!</h1>");
			/*/
			page.println("<code>");
			for (Map.Entry<String,String> pair : env.entrySet()) {
			    page.println(pair.getKey());
			    page.println(pair.getValue());
			}
			//*/
			page.println("</code>");
			page.println("</body></html>");
			page.close();
			
		} catch (Exception e) {
			// Escreve as mensagens de Exception em uma página de resposta.
			// Não apagar este bloco.
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			
			page.println("<html lang='pt-br'><head><title>Error</title></head><body>");
			page.println("<h1>Error</h1>");
			page.println("<code>" + sw.toString() + "</code>");
			page.println("</body></html>");
			page.close();
		} finally {
			
		}
	}
}
