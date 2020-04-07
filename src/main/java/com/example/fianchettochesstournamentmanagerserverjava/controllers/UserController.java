package com.example.fianchettochesstournamentmanagerserverjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fianchettochesstournamentmanagerserverjava.models.Tournament;
import com.example.fianchettochesstournamentmanagerserverjava.models.User;
import com.example.fianchettochesstournamentmanagerserverjava.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/get/user/{userId}")
	public User findUserById(@PathVariable ("userId") Integer userId) {
		return userService.findUserById(userId);
	}
	
//	@GetMapping("/get/user/:userId/tournaments")
//	public List<Tournament> findTournamentsForUser (@PathVariable ("userId") String userId) {
//		return userService.findTournamentsForUser(userId);
//	}
	
	@PostMapping("/create/users")
	public User createUser(@RequestBody User u) {
		return userService.createUser(u);
	}
	
	@DeleteMapping("/delete/user/{userId}")
	public void deleteUser(@PathVariable ("userId") Integer userId) {
		userService.deleteUser(userId);
	}
	
	@GetMapping("/get/users")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}
	

}
