package com.shashank.ecommerce.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shashank.ecommerce.model.User;
import com.shashank.ecommerce.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/update/{id}")
	public User updateUser(@RequestBody User user,@PathVariable int id) {
		return userService.updateUser(user, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
}
