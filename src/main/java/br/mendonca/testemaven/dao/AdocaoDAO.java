package br.mendonca.testemaven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.mendonca.testemaven.model.entities.Adocao;

public class AdocaoDAO {

	public void register(Adocao adocao) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionPostgres.getConexao();
		conn.setAutoCommit(true);
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO adocao(usuario_id, planta_id, status_adocao,data_adocao, lembrete_adocao) values (?,?,?, ?, ?)");
		ps.setString(1, adocao.getUsuarioId());
		ps.setString(2, adocao.getPlantaId());
		ps.setString(3, adocao.getDataAdocao());
		ps.setString(4, adocao.getStatusAdocao());
		ps.setString(5, adocao.getLembreteAdocao());
		ps.execute();
		ps.close();
	}
	
	public List<Adocao> listAllAdocao() throws ClassNotFoundException, SQLException {
		ArrayList<Adocao> lista = new ArrayList<Adocao>();
		
		Connection conn = ConnectionPostgres.getConexao();
		conn.setAutoCommit(true);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM adocao");
		
		while (rs.next()) {
			Adocao adocao = new Adocao();
			adocao.setUuid(rs.getString("uuid"));
			adocao.setPlantaId(rs.getString("planta_id"));
			adocao.setUsuarioId(rs.getString("usuario_id"));
			adocao.setDataAdocao(rs.getString("data_adocao"));
			adocao.setStatusAdocao(rs.getString("status_adocao"));
			adocao.setLembreteAdocao(rs.getString("lembrete_adocao"));
			lista.add(adocao);
		}
		
		rs.close();
		
		return lista;
	}

	public Adocao search(String uuid) throws ClassNotFoundException, SQLException {
		Adocao adocao = null;
		
		Connection conn = ConnectionPostgres.getConexao();
		conn.setAutoCommit(true);
		
		// Apesar de qualquer SQL funcionar com Statement, a abordagem de usar Prepared Statement evita SQL Injection.
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM adocao WHERE uuid = ?");
		ps.setString(1, uuid);
		System.out.println(ps); // Exibe no console do Docker a query j� montada.
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			
			adocao = new Adocao();
			adocao.setUuid(rs.getString("uuid"));
			adocao.setPlantaId(rs.getString("planta_id"));
			adocao.setUsuarioId(rs.getString("usuario_id"));
			adocao.setDataAdocao(rs.getString("data_adocao"));
			adocao.setStatusAdocao(rs.getString("status_adocao"));
			adocao.setLembreteAdocao(rs.getString("lembrete_adocao"));
		}
		
		rs.close();
		
		return adocao;
	}
}