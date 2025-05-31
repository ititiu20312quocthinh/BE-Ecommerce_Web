package org.sang.backendecommerce.service;

import java.util.List;
import java.util.Optional;
import org.sang.backendecommerce.dto.model.UserDTO;
import org.sang.backendecommerce.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
	String getAuthenticatedUserEmail();
	Optional<UserDTO> addUser(UserDTO userDTO);
	List<UserDTO> getUsers();
	Optional<UserDTO> getUserById(Long id);
	UserDTO getUserSafe();
	User getUserEntity();
	Optional<UserDTO> getUserByEmail(String email);
	Optional<UserDTO> updateUser(UserDTO userDTO);
	Optional<UserDTO> updateUserPassword(String password);
	boolean deleteUser(Long id);
	boolean deleteUser();
	UserDetailsService userDetailsService();
}
