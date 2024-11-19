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

    // Método para registrar uma planta
    public void register(Planta planta) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        conn.setAutoCommit(true);

        // Inserção de dados na tabela plantas
        PreparedStatement ps = conn.prepareStatement("INSERT INTO plantas (nome_cientifico, nome_popular, origem) VALUES (?,?,?)");
        ps.setString(1, planta.getNomeCientifico());
        ps.setString(2, planta.getNomePopular());
        ps.setString(3, planta.getOrigem());
        ps.execute();
        ps.close();
    }

    // Método para listar todas as plantas
    public List<Planta> listAllPlantas() throws ClassNotFoundException, SQLException {
        ArrayList<Planta> lista = new ArrayList<Planta>();

        Connection conn = ConnectionPostgres.getConexao();
        conn.setAutoCommit(true);

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM plantas");

        while (rs.next()) {
            Planta planta = new Planta();
            planta.setUuid(rs.getString("uuid"));
            planta.setNomeCientifico(rs.getString("nome_cientifico"));
            planta.setNomePopular(rs.getString("nome_popular"));
            planta.setOrigem(rs.getString("origem"));
            lista.add(planta);
        }

        rs.close();

        return lista;
    }

    public Planta search(String uuid) throws ClassNotFoundException, SQLException {
        Planta planta = null;

        Connection conn = ConnectionPostgres.getConexao();
        conn.setAutoCommit(true);

        // Converte a string para UUID
        java.util.UUID uuidParam = java.util.UUID.fromString(uuid);

        // Usando PreparedStatement para evitar SQL Injection
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM plantas WHERE uuid = ?");
        ps.setObject(1, uuidParam); // Passa o UUID como parâmetro

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            planta = new Planta();
            planta.setUuid(rs.getString("uuid"));
            planta.setNomeCientifico(rs.getString("nome_cientifico"));
            planta.setNomePopular(rs.getString("nome_popular"));
            planta.setOrigem(rs.getString("origem"));
        }

        rs.close();

        return planta;
    }

}
