package br.mendonca.testemaven.dao;

import br.mendonca.testemaven.model.entities.RelatorioCrescimento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCrescimentoDAO {

    public void criarTabelaRelatorioCrescimento() throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "CREATE TABLE IF NOT EXISTS relatorio_crescimento (" +
                     "id SERIAL PRIMARY KEY, " +
                     "data_registro INTEGER NOT NULL, " +  // Alterado para INTEGER
                     "altura DOUBLE PRECISION, " +
                     "saude VARCHAR(255), " +
                     "observacoes TEXT)";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        stmt.close();
    }

    public void inserirRelatorio(RelatorioCrescimento relatorio) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "INSERT INTO relatorio_crescimento (data_registro, altura, saude, observacoes) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, relatorio.getDataRegistro());  // Alterado para setInt
        ps.setDouble(2, relatorio.getAltura());
        ps.setString(3, relatorio.getSaude());
        ps.setString(4, relatorio.getObservacoes());
        ps.execute();
        ps.close();
    }

    public List<RelatorioCrescimento> listarRelatorios() throws ClassNotFoundException, SQLException {
        List<RelatorioCrescimento> lista = new ArrayList<>();
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "SELECT * FROM relatorio_crescimento";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            RelatorioCrescimento relatorio = new RelatorioCrescimento();
            relatorio.setId(rs.getInt("id"));
            relatorio.setDataRegistro(rs.getInt("data_registro"));  // Alterado para getInt
            relatorio.setAltura(rs.getDouble("altura"));
            relatorio.setSaude(rs.getString("saude"));
            relatorio.setObservacoes(rs.getString("observacoes"));
            lista.add(relatorio);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}
