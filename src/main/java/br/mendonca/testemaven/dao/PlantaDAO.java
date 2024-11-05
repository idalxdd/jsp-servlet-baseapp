package br.mendonca.testemaven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.mendonca.testemaven.model.entities.Planta;

public class PlantaDAO {

    // Método para registrar uma nova planta no banco de dados
    public void register(Planta planta) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        conn.setAutoCommit(true);
        
        String sql = "INSERT INTO plantas (nome_cientifico, nome_popular, origem) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, planta.getNomeCientifico());
        ps.setString(2, planta.getNomePopular());
        ps.setString(3, planta.getOrigem());
        ps.execute();
        ps.close();
    }

    // Método para listar todas as plantas do banco de dados
    public List<Planta> listAllPlantas() throws ClassNotFoundException, SQLException {
        List<Planta> lista = new ArrayList<>();
        
        Connection conn = ConnectionPostgres.getConexao();
        conn.setAutoCommit(true);
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM plantas");
        
        while (rs.next()) {
            Planta planta = new Planta();
            planta.setId(rs.getString("id"));
            planta.setNomeCientifico(rs.getString("nome_cientifico"));
            planta.setNomePopular(rs.getString("nome_popular"));
            planta.setOrigem(rs.getString("origem"));
            
            lista.add(planta);
        }
        
        rs.close();
        st.close();
        
        return lista;
    }

    // Método para buscar uma planta pelo nome científico
    public Planta searchByNomeCientifico(String nomeCientifico) throws ClassNotFoundException, SQLException {
        Planta planta = null;
        
        Connection conn = ConnectionPostgres.getConexao();
        conn.setAutoCommit(true);
        
        String sql = "SELECT * FROM plantas WHERE nome_cientifico = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nomeCientifico);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            planta = new Planta();
            planta.setId(rs.getString("id"));
            planta.setNomeCientifico(rs.getString("nome_cientifico"));
            planta.setNomePopular(rs.getString("nome_popular"));
            planta.setOrigem(rs.getString("origem"));
        }
        
        rs.close();
        ps.close();
        
        return planta;
    }

    // Método para buscar plantas pelo nome popular
    public List<Planta> searchByNomePopular(String nomePopular) throws ClassNotFoundException, SQLException {
        List<Planta> lista = new ArrayList<>();
        
        Connection conn = ConnectionPostgres.getConexao();
        conn.setAutoCommit(true);
        
        String sql = "SELECT * FROM plantas WHERE LOWER(nome_popular) LIKE LOWER(?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + nomePopular + "%");
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Planta planta = new Planta();
            planta.setId(rs.getString("id"));
            planta.setNomeCientifico(rs.getString("nome_cientifico"));
            planta.setNomePopular(rs.getString("nome_popular"));
            planta.setOrigem(rs.getString("origem"));
            
            lista.add(planta);
        }
        
        rs.close();
        ps.close();
        
        return lista;
    }
}
