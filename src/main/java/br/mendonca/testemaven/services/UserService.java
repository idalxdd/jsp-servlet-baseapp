package br.mendonca.testemaven.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.mendonca.testemaven.dao.UserDAO;
import br.mendonca.testemaven.model.entities.User;
import br.mendonca.testemaven.services.dto.UserDTO;

public class UserService {
	
	public void register(String name, String email, String password) throws ClassNotFoundException, SQLException {
		UserDAO dao = new UserDAO();
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		dao.register(user);
	}
	
	public List<UserDTO> listAllUsers() throws ClassNotFoundException, SQLException {
		ArrayList<UserDTO> resp = new ArrayList<UserDTO>();
		
		UserDAO dao = new UserDAO();
		List<User> lista = dao.listAllUser();
		
		for (User user : lista) {
			resp.add(UserDTO.userMapper(user));
		}
		
		return resp;
	}
	public List<UserDTO> getFollowing(String followerUuid) throws ClassNotFoundException, SQLException {
		UserDAO dao = new UserDAO();
		List<String> followingUuids = dao.getFollowing(followerUuid); // Obtem os UUIDs dos usuários seguidos
		List<UserDTO> following = new ArrayList<>();
	
		for (String uuid : followingUuids) {
			User user = dao.searchByUuid(uuid); // Busca os detalhes de cada usuário pelo UUID
			if (user != null) {
				following.add(UserDTO.userMapper(user)); // Converte para DTO
			}
		}
		return following;
	}
	
}
