package br.mendonca.testemaven.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import br.mendonca.testemaven.dao.AdocaoDAO;
import br.mendonca.testemaven.dao.UserDAO;
import br.mendonca.testemaven.model.entities.Adocao;
import br.mendonca.testemaven.model.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastroAdocao")
public class CadastroAdocaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Caso o usu�rio tente acessar este end point pelo m�todo GET, recebe a p�gina de formul�rio JSP.
		response.sendRedirect("form-register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter page = response.getWriter();
		
		try {
			String usuarioId = request.getParameter("usuarioId");
			String plantaId = request.getParameter("plantaId");
			String dataAdocao = request.getParameter("dataAdocao");
			String statusAdocao = request.getParameter("statusAdocao");
			String lembreteAdocao = request.getParameter("lembreteAdocao");
			
			Adocao adocao = new Adocao();
			
			adocao.setUsuarioId(usuarioId);
			adocao.setPlantaId(plantaId);
			adocao.setDataAdocao(dataAdocao);
			adocao.setStatusAdocao(statusAdocao);
			adocao.setLembreteAdocao(lembreteAdocao);
			
			AdocaoDAO adocaoDAO = new AdocaoDAO();
			adocaoDAO.register(adocao);
			
			response.sendRedirect("/dashboard/dashboard.jsp");

			
		} catch (Exception e) {
			// Escreve as mensagens de Exception em uma p�gina de resposta.
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
