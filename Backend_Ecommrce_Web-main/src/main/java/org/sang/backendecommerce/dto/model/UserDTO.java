package org.sang.backendecommerce.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sang.backendecommerce.model.UserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private Long id;
	private String name;
	private String email;
	private String password;
	private UserRole role;

	public UserDTO update(UserDTO newUserDTO) {
		if (newUserDTO.getName() != null) {
			this.setName(newUserDTO.getName());
		}
		if (newUserDTO.getEmail() != null) {
			this.setEmail(newUserDTO.getEmail());
		}
		if (newUserDTO.getPassword() != null) {
			this.setPassword(newUserDTO.getPassword());
		}
		if (newUserDTO.getRole() != null) {
			this.setRole(newUserDTO.getRole());
		}
		return this;
	}
}
