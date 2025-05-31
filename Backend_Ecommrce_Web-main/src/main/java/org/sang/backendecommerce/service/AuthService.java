package org.sang.backendecommerce.service;

import org.sang.backendecommerce.dto.model.UserDTO;
import org.sang.backendecommerce.dto.request.SigninResponseDTO;

public interface AuthService {
	UserDTO signUp(UserDTO userDTO);
	SigninResponseDTO logIn(UserDTO userDTO);
}
