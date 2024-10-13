package br.mendonca.testemaven.services;

import java.sql.SQLException;

import br.mendonca.testemaven.dao.UserDAO;
import br.mendonca.testemaven.model.entities.User;
import br.mendonca.testemaven.services.dto.UserDTO;

public class AuthenticationService {

	
	public UserDTO login(String email, String password) throws ClassNotFoundException, SQLException {
		
		UserDAO dao = new UserDAO();
		User user = dao.search(email, password);
		
		if (user == null) return null;
		
		// DTO = Data Transfer Object
		return UserDTO.userMapper(user);
	}
}
