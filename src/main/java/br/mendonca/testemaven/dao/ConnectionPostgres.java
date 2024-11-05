package br.mendonca.testemaven.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class ConnectionPostgres {

	private static Connection connection = null;
	
	public static Connection getConexao() throws SQLException, ClassNotFoundException {
		if (connection == null) {
			Map<String, String> env = System.getenv();
			String DB_USER = env.get("postgres");
			String DB_PASS = env.get("abacax123@");
			String DB_HOST = env.get("postgres");
			String DB_NAME = env.get("DB_NAME"); //criar postgres
			
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://" + DB_HOST+ ":5432/" + DB_NAME, DB_USER, DB_PASS);
		}
		return connection;
	}
}
