package br.mendonca.testemaven.controller;

import br.mendonca.testemaven.services.RelatorioCrescimentoService;
import br.mendonca.testemaven.services.dto.RelatorioCrescimentoDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/relatorioCrescimento")
public class RelatorioCrescimentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final int PAGE_SIZE = 3; // Registros por página

    private RelatorioCrescimentoService service = new RelatorioCrescimentoService();

    // Método doGet para listar os relatórios com paginação
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        String action = request.getParameter("action");

        if ("ocultos".equals(action)) {
            // Busca os relatórios ocultos
            List<RelatorioCrescimentoDTO> relatoriosOcultos = service.listarRelatoriosOcultos();
            request.setAttribute("relatorios", relatoriosOcultos);

            // Encaminha para a página de listagem de ocultos
            request.getRequestDispatcher("/dashboard/list-relatorios-ocultos.jsp").forward(request, response);

        } else {
            // Exibe a listagem paginada normal
            int pageNumber = 1;
            if (request.getParameter("page") != null) {
                pageNumber = Integer.parseInt(request.getParameter("page"));
            }

            List<RelatorioCrescimentoDTO> relatorios = service.listarRelatoriosPaginado(pageNumber);
            int totalRelatorios = service.contarTotalRelatorios();
            int totalPages = (int) Math.ceil((double) totalRelatorios / PAGE_SIZE);

            request.setAttribute("relatorios", relatorios);
            request.setAttribute("currentPage", pageNumber);
            request.setAttribute("totalPages", totalPages);

            request.getRequestDispatcher("/dashboard/list-relatorios.jsp").forward(request, response);
        }

    } catch (Exception e) {
        e.printStackTrace();
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao processar a solicitação.");
    }
}


    // Método doPost para adicionar um novo relatório
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            service.marcarComoInativo(id);
            response.sendRedirect("relatorioCrescimento");
        } else {
            int dataRegistro = Integer.parseInt(request.getParameter("dataRegistro"));
            double altura = Double.parseDouble(request.getParameter("altura"));
            String saude = request.getParameter("saude");
            String observacoes = request.getParameter("observacoes");

            RelatorioCrescimentoDTO dto = new RelatorioCrescimentoDTO();
            dto.setDataRegistro(dataRegistro);
            dto.setAltura(altura);
            dto.setSaude(saude);
            dto.setObservacoes(observacoes);

            service.inserirRelatorio(dto);

            response.sendRedirect("relatorioCrescimento");
        }

    } catch (Exception e) {
        e.printStackTrace();
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao processar o formulário: " + e.getMessage());
    }
}

}
