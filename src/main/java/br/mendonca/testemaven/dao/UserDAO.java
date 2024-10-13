package br.mendonca.testemaven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.mendonca.testemaven.model.entities.User;

public class UserDAO {

	public void register(User user) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionPostgres.getConexao();
		conn.setAutoCommit(true);
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO users (name, email, password) values (?,?,?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.execute();
		ps.close();
	}
	
	public List<User> listAllUser() throws ClassNotFoundException, SQLException {
		ArrayList<User> lista = new ArrayList<User>();
		
		Connection conn = ConnectionPostgres.getConexao();
		conn.setAutoCommit(true);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM users");
		
		while (rs.next()) {
			User user = new User();
			user.setUuid(rs.getString("uuid"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			
			lista.add(user);
		}
		
		rs.close();
		
		return lista;
	}
}
