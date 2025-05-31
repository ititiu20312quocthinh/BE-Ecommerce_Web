package org.sang.backendecommerce.controller;

import org.sang.backendecommerce.dto.model.UserDTO;
import org.sang.backendecommerce.dto.request.SigninResponseDTO;
import org.sang.backendecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1/auth")
public class AuthController {
	private final AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/signup")
	public UserDTO signUp(@RequestBody UserDTO userDTO) {
		if (userDTO == null) {
			throw new IllegalArgumentException("User info is required");
		}
		if (userDTO.getId() != null) {
			throw new IllegalArgumentException("User id must be null");
		}
		return authService.signUp(userDTO);
	}

	@PostMapping("/login")
	public ResponseEntity<SigninResponseDTO> logIn(@RequestBody UserDTO userDTO){
		return ResponseEntity.ok(authService.logIn(userDTO));
	}
}
