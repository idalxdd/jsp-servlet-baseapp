package br.mendonca.testemaven.dao;

import br.mendonca.testemaven.model.entities.RelatorioCrescimento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCrescimentoDAO {

    private static final int PAGE_SIZE = 3; // Número de registros por página

    public List<RelatorioCrescimento> listarRelatoriosPaginado(int pageNumber) throws ClassNotFoundException, SQLException {
        List<RelatorioCrescimento> lista = new ArrayList<>();
        Connection conn = ConnectionPostgres.getConexao();
    
        int offset = (pageNumber - 1) * PAGE_SIZE;
        String sql = "SELECT * FROM relatorio_crescimento WHERE ativo = TRUE ORDER BY id LIMIT ? OFFSET ?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, PAGE_SIZE);
        ps.setInt(2, offset);
        ResultSet rs = ps.executeQuery();
    
        while (rs.next()) {
            RelatorioCrescimento relatorio = new RelatorioCrescimento();
            relatorio.setId(rs.getInt("id"));
            relatorio.setDataRegistro(rs.getInt("data_registro"));
            relatorio.setAltura(rs.getDouble("altura"));
            relatorio.setSaude(rs.getString("saude"));
            relatorio.setObservacoes(rs.getString("observacoes"));
            lista.add(relatorio);
        }
        rs.close();
        ps.close();
        return lista;
    }

    public List<RelatorioCrescimento> listarRelatoriosOcultos() throws ClassNotFoundException, SQLException {
        List<RelatorioCrescimento> lista = new ArrayList<>();
        Connection conn = ConnectionPostgres.getConexao();
    
        String sql = "SELECT * FROM relatorio_crescimento WHERE ativo = FALSE ORDER BY id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    
        while (rs.next()) {
            RelatorioCrescimento relatorio = new RelatorioCrescimento();
            relatorio.setId(rs.getInt("id"));
            relatorio.setDataRegistro(rs.getInt("data_registro"));
            relatorio.setAltura(rs.getDouble("altura"));
            relatorio.setSaude(rs.getString("saude"));
            relatorio.setObservacoes(rs.getString("observacoes"));
            lista.add(relatorio);
        }
        rs.close();
        ps.close();
        return lista;
    }
    
    public void marcarComoInativo(int id) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "UPDATE relatorio_crescimento SET ativo = FALSE WHERE id = ?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }
    
    

    public int contarTotalRelatorios() throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "SELECT COUNT(*) AS total FROM relatorio_crescimento";
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        rs.next();
        int total = rs.getInt("total");
        
        rs.close();
        stmt.close();
        return total;
    }
    public void inserirRelatorio(RelatorioCrescimento relatorio) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "INSERT INTO relatorio_crescimento (data_registro, altura, saude, observacoes) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, relatorio.getDataRegistro());
        ps.setDouble(2, relatorio.getAltura());
        ps.setString(3, relatorio.getSaude());
        ps.setString(4, relatorio.getObservacoes());
        ps.execute();
        ps.close();
    }
}
