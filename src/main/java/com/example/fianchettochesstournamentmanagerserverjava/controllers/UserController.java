package com.example.fianchettochesstournamentmanagerserverjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable ("userId") Integer userId) {
		return userService.findUserById(userId);
	}
	
	@GetMapping("/api/user/{userId}/tournaments")
	public List<Tournament> findTournamentsForUser (@PathVariable ("userId") Integer userId) {
		return userService.findTournamentsForUser(userId);
	}
	
	@PostMapping("/api/login")
	public User login(@RequestBody User u) {
		return userService.login(u);
	}
	
	@PutMapping("/api/user/{userId}/tournament/{tournamentId}")
	public int registerToTournament(@PathVariable ("userId") Integer userId
			, @PathVariable ("tournamentId") Integer tournamentId) {
		return userService.registerToTournament(userId, tournamentId);
	}
	
	@DeleteMapping("/api/user/{userId}/tournament/{tournamentId}")
	public int deregisterFromTournamement(@PathVariable ("userId") Integer userId
			, @PathVariable ("tournamentId") Integer tournamentId) {
		return userService.deregisterFromTournamement(userId, tournamentId);
	}
	
	@PostMapping("/api/users")
	public User createUser(@RequestBody User u) {
		return userService.createUser(u);
	}
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable ("userId") Integer userId) {
		userService.deleteUser(userId);
	}
	
	@GetMapping("/api/users")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}
	

}
