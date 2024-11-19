package br.mendonca.testemaven.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.mendonca.testemaven.dao.PlantaDAO;
import br.mendonca.testemaven.model.entities.Planta;

public class PlantaService {
    
    // Instância do DAO para interação com o banco de dados
    PlantaDAO dao = new PlantaDAO();
    
    // Método para registrar uma planta
    public void register(String nomeCientifico, String nomePopular, String origem) throws ClassNotFoundException, SQLException {
        
        Planta planta = new Planta();
        planta.setNomeCientifico(nomeCientifico);
        planta.setNomePopular(nomePopular);
        planta.setOrigem(origem);
        
        dao.register(planta); // Chama o DAO para registrar a planta no banco
    }
    
    public Planta search(String uuid) throws ClassNotFoundException, SQLException {
        return dao.search(uuid); // Chama o DAO para buscar a planta pelo UUID
    }
    
    // Método para listar todas as plantas
    public List<Planta> listAllPlantas() throws ClassNotFoundException, SQLException {
        ArrayList<Planta> resp = new ArrayList<Planta>();
        
        // Obtém a lista de plantas do DAO
        List<Planta> lista = dao.listAllPlantas();
        
        // Adiciona as plantas à resposta
        for (Planta planta : lista) {
            resp.add(planta);
        }
        
        return resp; // Retorna a lista de plantas
    }
}
