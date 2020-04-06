package com.example.fianchettochesstournamentmanagerserverjava.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fianchettochesstournamentmanagerserverjava.models.User;
import com.example.fianchettochesstournamentmanagerserverjava.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	UserService userService = new UserService();
	
	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable ("userId") String userId) {
		return userService.findUserById(userId);
	}
	
	@PostMapping("/create/users")
	public User createUser(@RequestBody User u) {
		return userService.createUser(u);
	}
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable ("userId") String userId) {
		userService.deleteUser(userId);
	}
	
	@GetMapping("/api/users")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}
	

}
