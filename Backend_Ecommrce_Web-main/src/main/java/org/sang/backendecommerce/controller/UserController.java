package org.sang.backendecommerce.controller;

import java.util.List;
import java.util.MissingFormatArgumentException;
import org.sang.backendecommerce.dto.model.UserDTO;
import org.sang.backendecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/user")
	public UserDTO getUser() {
		return userService.getUserSafe();
	}

	@PutMapping("/user")
	public UserDTO updateUser(@RequestBody UserDTO userDTO) {
		return userService.updateUser(userDTO).orElseThrow(() -> new MissingFormatArgumentException("User not updated"));
	}

	@DeleteMapping("/user")
	public boolean deleteUser() {
		return userService.deleteUser();
	}
}
