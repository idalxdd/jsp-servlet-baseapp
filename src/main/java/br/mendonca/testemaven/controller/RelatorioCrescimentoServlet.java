package br.mendonca.testemaven.controller;

import br.mendonca.testemaven.services.RelatorioCrescimentoService;
import br.mendonca.testemaven.services.dto.RelatorioCrescimentoDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@WebServlet("/relatorioCrescimento")
public class RelatorioCrescimentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RelatorioCrescimentoService service = new RelatorioCrescimentoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter page = response.getWriter();

        try {
            // Listando os relatórios de crescimento
            List<RelatorioCrescimentoDTO> relatorios = service.listarRelatorios();
            request.setAttribute("relatorios", relatorios);
            request.getRequestDispatcher("/dashboard/list-relatorios.jsp").forward(request, response);

        } catch (Exception e) {
            // Tratamento de exceção e impressão de stack trace na página
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            page.println("<html lang='pt-br'><head><title>Error</title></head><body>");
            page.println("<h1>Error</h1>");
            page.println("<code>" + sw.toString() + "</code>");
            page.println("</body></html>");
            page.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter page = response.getWriter();

        try {
            // Captura os parâmetros do formulário e cria o DTO
            int dataRegistro = Integer.parseInt(request.getParameter("dataRegistro"));
            double altura = Double.parseDouble(request.getParameter("altura"));
            String saude = request.getParameter("saude");
            String observacoes = request.getParameter("observacoes");

            RelatorioCrescimentoDTO dto = new RelatorioCrescimentoDTO();
            dto.setDataRegistro(dataRegistro);
            dto.setAltura(altura);
            dto.setSaude(saude);
            dto.setObservacoes(observacoes);

            // Chama o serviço para inserir o relatório no banco de dados
            service.inserirRelatorio(dto);

            // Redireciona para a página de listagem após a inserção
            response.sendRedirect("/relatorioCrescimento");

        } catch (Exception e) {
            // Tratamento de exceção e impressão de stack trace na página
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            page.println("<html lang='pt-br'><head><title>Error</title></head><body>");
            page.println("<h1>Error</h1>");
            page.println("<code>" + sw.toString() + "</code>");
            page.println("</body></html>");
            page.close();
        }
    }
}
