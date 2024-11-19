package br.mendonca.testemaven.services.dto;

import br.mendonca.testemaven.model.entities.User;

public class UserDTO {
	
	private String name;
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public static UserDTO userMapper(User user) {
		UserDTO dto = new UserDTO();
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		
		return dto;
	}
}
