package br.mendonca.testemaven.services;

import br.mendonca.testemaven.dao.RelatorioCrescimentoDAO;
import br.mendonca.testemaven.model.entities.RelatorioCrescimento;
import br.mendonca.testemaven.services.dto.RelatorioCrescimentoDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCrescimentoService {

    private RelatorioCrescimentoDAO dao = new RelatorioCrescimentoDAO();

    public void criarTabela() throws ClassNotFoundException, SQLException {
        dao.criarTabelaRelatorioCrescimento();
    }

    public void inserirRelatorio(RelatorioCrescimentoDTO dto) throws ClassNotFoundException, SQLException {
        RelatorioCrescimento relatorio = new RelatorioCrescimento();
        relatorio.setDataRegistro(dto.getDataRegistro());  // Alterado para int
        relatorio.setAltura(dto.getAltura());
        relatorio.setSaude(dto.getSaude());
        relatorio.setObservacoes(dto.getObservacoes());
        dao.inserirRelatorio(relatorio);
    }

    public List<RelatorioCrescimentoDTO> listarRelatorios() throws ClassNotFoundException, SQLException {
        List<RelatorioCrescimentoDTO> listaDTO = new ArrayList<>();
        List<RelatorioCrescimento> lista = dao.listarRelatorios();
        for (RelatorioCrescimento relatorio : lista) {
            listaDTO.add(RelatorioCrescimentoDTO.mapper(relatorio));
        }
        return listaDTO;
    }
}
