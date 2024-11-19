package br.mendonca.testemaven.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.mendonca.testemaven.dao.ConnectionPostgres;

public class InstallService {

    // Método genérico para executar comandos SQL
    private void statement(String sql) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        conn.setAutoCommit(true);
        
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
        st.close();
    }

    // Método de teste de conexão
    public void testConnection() throws ClassNotFoundException, SQLException {
        ConnectionPostgres.getConexao();
    }

    // Método para excluir a tabela de plantas
    public void deletePlantaTable() throws ClassNotFoundException, SQLException {
        statement("DROP TABLE IF EXISTS plantas CASCADE");
    }

    // Método para criar a tabela de plantas
    public void createPlantaTable() throws ClassNotFoundException, SQLException {
        statement("CREATE TABLE plantas ("
                + "    uuid UUID DEFAULT gen_random_uuid() PRIMARY KEY,"
                + "    nome_cientifico VARCHAR(255) NOT NULL,"
                + "    nome_popular VARCHAR(255) NOT NULL,"
                + "    origem VARCHAR(255))");
    }

    // Método para inserir plantas na tabela
    public void insertPlantas() throws ClassNotFoundException, SQLException {
        String[] plantas = {
            "INSERT INTO plantas (nome_cientifico, nome_popular, origem) VALUES ('Rosa rubiginosa', 'Rosa', 'Europa')",
            "INSERT INTO plantas (nome_cientifico, nome_popular, origem) VALUES ('Ocimum basilicum', 'Manjericão', 'Índia')",
            "INSERT INTO plantas (nome_cientifico, nome_popular, origem) VALUES ('Helianthus annuus', 'Girassol', 'América do Norte')",
            "INSERT INTO plantas (nome_cientifico, nome_popular, origem) VALUES ('Zea mays', 'Milho', 'México')",
            "INSERT INTO plantas (nome_cientifico, nome_popular, origem) VALUES ('Coffea arabica', 'Café', 'Etiópia')",
            "INSERT INTO plantas (nome_cientifico, nome_popular, origem) VALUES ('Solanum tuberosum', 'Batata', 'América do Sul')",
            "INSERT INTO plantas (nome_cientifico, nome_popular, origem) VALUES ('Oryza sativa', 'Arroz', 'Ásia')"
        };

        for (String planta : plantas) {
            statement(planta);
        }
    }

    // Método para excluir a tabela de usuários (caso necessário)
    public void deleteUserTable() throws ClassNotFoundException, SQLException {
        statement("DROP TABLE IF EXISTS users CASCADE");
    }

    // Método para criar a tabela de usuários (caso necessário)
    public void createUserTable() throws ClassNotFoundException, SQLException {
        statement("CREATE TABLE users ("
                + "    uuid UUID DEFAULT gen_random_uuid() PRIMARY KEY,"
                + "    name VARCHAR(255) NOT NULL,"
                + "    email VARCHAR(255) NOT NULL,"
                + "    password VARCHAR(255) NOT NULL)");
    }
}