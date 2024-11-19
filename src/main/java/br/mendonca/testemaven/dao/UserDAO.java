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

	public void followUser(String followerUuid, String followingUuid) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionPostgres.getConexao();
		String sql = "INSERT INTO user_following (follower_uuid, following_uuid) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, followerUuid);
		ps.setString(2, followingUuid);
		ps.execute();
		ps.close();
	}

	public User searchByUuid(String uuid) throws ClassNotFoundException, SQLException {
    User user = null;

    Connection conn = ConnectionPostgres.getConexao();
    conn.setAutoCommit(true);

    String sql = "SELECT * FROM users WHERE uuid = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, uuid);

    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        user = new User();
        user.setUuid(rs.getString("uuid"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password")); // Incluído caso seja necessário
    }

    rs.close();
    ps.close();

    return user;
}
	
	
	public void unfollowUser(String followerUuid, String followingUuid) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionPostgres.getConexao();
		String sql = "DELETE FROM user_following WHERE follower_uuid = ? AND following_uuid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, followerUuid);
		ps.setString(2, followingUuid);
		ps.execute();
		ps.close();
	}
	
	public List<String> getFollowing(String followerUuid) throws SQLException, ClassNotFoundException {
		List<String> following = new ArrayList<>();
		Connection conn = ConnectionPostgres.getConexao();
		String sql = "SELECT following_uuid FROM user_following WHERE follower_uuid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, followerUuid);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			following.add(rs.getString("following_uuid"));
		}
		rs.close();
		ps.close();
		return following;
	}
	
	
	public User search(String email, String password) throws ClassNotFoundException, SQLException {
		User user = null;
		
		Connection conn = ConnectionPostgres.getConexao();
		conn.setAutoCommit(true);
		
		// Apesar de qualquer SQL funcionar com Statement, a abordagem de usar Prepared Statement evita SQL Injection.
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
		ps.setString(1, email);
		ps.setString(2, password);
		System.out.println(ps); // Exibe no console do Docker a query j� montada.
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			
			user = new User();
			user.setUuid(rs.getString("uuid"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
		}
		
		rs.close();
		
		return user;
	}

	// TODO: N�o testado
	public List<User> search(String name) throws ClassNotFoundException, SQLException {
		ArrayList<User> lista = new ArrayList<User>();
		
		Connection conn = ConnectionPostgres.getConexao();
		conn.setAutoCommit(true);
		
		// Apesar de qualquer SQL funcionar com Statement, a abordagem de usar Prepared Statement evita SQL Injection.
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE ? LIKE LOWER(?) || LOWER(name) || '%'");
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
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
