package br.mendonca.testemaven.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.mendonca.testemaven.dao.AdocaoDAO;
import br.mendonca.testemaven.model.entities.Adocao;

public class AdocaoService {
	
	AdocaoDAO dao = new AdocaoDAO();
	
	public void register(String usuarioId, String plantaId, String dataAdocao, String statusAdocao, String lembreteAdocao) throws ClassNotFoundException, SQLException {
		
		Adocao adocao = new Adocao();
		adocao.setUsuarioId(usuarioId);
		adocao.setPlantaId(plantaId);
		adocao.setDataAdocao(dataAdocao);
		adocao.setStatusAdocao(statusAdocao);
		adocao.setLembreteAdocao(lembreteAdocao);
		
		dao.register(adocao);
	}
	
	public List<Adocao> listAllAdocoes() throws ClassNotFoundException, SQLException {
		ArrayList<Adocao> resp = new ArrayList<Adocao>();
		
		Adocao adocao = new Adocao();
		List<Adocao> lista = dao.listAllAdocao();
		
		for (Adocao a : lista) {
			resp.add(a);
		}
		
		return resp;
	}
}
