package br.mendonca.testemaven.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.mendonca.testemaven.dao.PlantaDAO;
import br.mendonca.testemaven.model.entities.Planta;
import br.mendonca.testemaven.services.dto.PlantaDTO;

public class PlantaService {

    // Método para registrar uma nova planta
    public void register(String nomeCientifico, String nomePopular, String origem) throws ClassNotFoundException, SQLException {
        PlantaDAO dao = new PlantaDAO();
        
        Planta planta = new Planta();
        planta.setNomeCientifico(nomeCientifico);
        planta.setNomePopular(nomePopular);
        planta.setOrigem(origem);
        
        dao.register(planta);
    }

    // Método para listar todas as plantas
    public List<PlantaDTO> listAllPlantas() throws ClassNotFoundException, SQLException {
        List<PlantaDTO> resp = new ArrayList<>();
        
        PlantaDAO dao = new PlantaDAO();
        List<Planta> lista = dao.listAllPlantas();
        
        for (Planta planta : lista) {
            resp.add(PlantaDTO.plantaMapper(planta));
        }
        
        return resp;
    }
}
