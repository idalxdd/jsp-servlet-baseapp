package br.mendonca.testemaven.services;

import br.mendonca.testemaven.dao.RelatorioCrescimentoDAO;
import br.mendonca.testemaven.model.entities.RelatorioCrescimento;
import br.mendonca.testemaven.services.dto.RelatorioCrescimentoDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCrescimentoService {

    private RelatorioCrescimentoDAO dao = new RelatorioCrescimentoDAO();

    // Método para listar relatórios com paginação
    public List<RelatorioCrescimentoDTO> listarRelatoriosPaginado(int pageNumber) throws ClassNotFoundException, SQLException {
        List<RelatorioCrescimento> lista = dao.listarRelatoriosPaginado(pageNumber);
        List<RelatorioCrescimentoDTO> listaDTO = new ArrayList<>();

        for (RelatorioCrescimento relatorio : lista) {
            listaDTO.add(RelatorioCrescimentoDTO.mapper(relatorio));
        }

        return listaDTO;
    }

    // Método para contar o total de relatórios no banco de dados
    public int contarTotalRelatorios() throws ClassNotFoundException, SQLException {
        return dao.contarTotalRelatorios();
    }

    public void marcarComoInativo(int id) throws ClassNotFoundException, SQLException {
        dao.marcarComoInativo(id);
    }
    
    public List<RelatorioCrescimentoDTO> listarRelatoriosOcultos() throws ClassNotFoundException, SQLException {
        List<RelatorioCrescimento> lista = dao.listarRelatoriosOcultos();
        List<RelatorioCrescimentoDTO> listaDTO = new ArrayList<>();
    
        for (RelatorioCrescimento relatorio : lista) {
            listaDTO.add(RelatorioCrescimentoDTO.mapper(relatorio));
        }
    
        return listaDTO;
    }
    

    // Método para inserir um novo relatório no banco de dados
    public void inserirRelatorio(RelatorioCrescimentoDTO dto) throws ClassNotFoundException, SQLException {
        // Converte o DTO para a entidade antes de salvar no banco
        RelatorioCrescimento relatorio = new RelatorioCrescimento();
        relatorio.setDataRegistro(dto.getDataRegistro());
        relatorio.setAltura(dto.getAltura());
        relatorio.setSaude(dto.getSaude());
        relatorio.setObservacoes(dto.getObservacoes());

        // Chama o DAO para inserir o novo relatório
        dao.inserirRelatorio(relatorio);
    }
}
