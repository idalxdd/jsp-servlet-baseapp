package br.mendonca.testemaven.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.mendonca.testemaven.dao.ConnectionPostgres;

public class InstallService {
	
	private void statement(String sql) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionPostgres.getConexao();
		conn.setAutoCommit(true);
		
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
		st.close();
	}
	
	public void testConnection() throws ClassNotFoundException, SQLException {
		ConnectionPostgres.getConexao();
	}
	
	public void deleteUserTable() throws ClassNotFoundException, SQLException {
		statement("DROP TABLE IF EXISTS users");
	}
	
	public void createUserTable() throws ClassNotFoundException, SQLException {
		statement("CREATE TABLE users ("
					+ "    uuid UUID DEFAULT gen_random_uuid() PRIMARY KEY,"
					+ "    name VARCHAR(255) NOT NULL,"
					+ "    email VARCHAR(255) NOT NULL,"
					+ "    password VARCHAR(255) NOT NULL)");
	}
	
	
	public void deleteAdocaoTable() throws ClassNotFoundException, SQLException {
		statement("DROP TABLE IF EXISTS adocao");
	}
	
	
	public void createAdocaoTable() throws ClassNotFoundException, SQLException {
		statement("CREATE TABLE adocao ("
			     + "    uuid UUID DEFAULT gen_random_uuid() PRIMARY KEY,"
			     + "    usuario_id VARCHAR(255) NOT NULL,"
			     + "    planta_id VARCHAR(255) NOT NULL,"
			     + "    status_adocao VARCHAR(255) NOT NULL,"
			     + "    data_adocao VARCHAR(255) NOT NULL,"
			     + "    lembrete_adocao VARCHAR(255) NOT NULL)");
	}
	
	

	public void createRelatorioTable() throws ClassNotFoundException, SQLException {
        statement("CREATE TABLE IF NOT EXISTS relatorio_crescimento ("
                + "id SERIAL PRIMARY KEY,"
                + "data_registro INT,"
                + "altura FLOAT,"
                + "saude VARCHAR(100),"
                + "observacoes TEXT)");

				String sqlInsertExamples = "INSERT INTO relatorio_crescimento (data_registro, altura, saude, observacoes) VALUES " +
				"(20230101, 15.5, 'Boa', 'Planta em crescimento saudável.'), " +
				"(20230105, 18.2, 'Regular', 'Apresenta leve amarelamento nas folhas.'), " +
				"(20230110, 20.3, 'Boa', 'Respondeu bem à adubação.'), " +
				"(20230115, 22.0, 'Ruim', 'Folhas com pontos marrons.'), " +
				"(20230120, 24.1, 'Boa', 'Crescimento vigoroso e folhas verdes.'), " +
				"(20230125, 26.4, 'Boa', 'Necessita de mais água.'), " +
				"(20230130, 28.8, 'Regular', 'Folhas secando nas pontas devido ao calor.')";
			statement(sqlInsertExamples);			
	
				
    }
	

}
