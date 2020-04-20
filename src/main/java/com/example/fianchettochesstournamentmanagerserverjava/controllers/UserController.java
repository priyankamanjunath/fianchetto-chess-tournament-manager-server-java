package com.example.fianchettochesstournamentmanagerserverjava.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
//	@PostMapping("/api/logout")
//	public void logout(HttpSession session) {
//		session.invalidate();
//	}
	
	@PostMapping("/api/login")
	public User login(HttpSession session, @RequestBody User u) {
		User user = userService.login(u);
//		if (user != null) {
//			session.setAttribute("user", user);
//		}
		return user;
	}
	
//	@PostMapping("/api/user")
//	public User getCurrentUser(HttpSession session) {
//		return (User) session.getAttribute("user");
//	}
	
	@GetMapping("/api/user/{userId}/tournament/{tournamentId}")
	public Double findUserPointsForTournament(@PathVariable("userId") Integer userId, @PathVariable("tournamentId") Integer tournamentId) {
		return userService.findUserPointsForTournament(userId, tournamentId);
	}
	
	@GetMapping("/api/user/{userId}/tournamentsLeft")
	public List<Tournament> findTournamentsLeftForUser(@PathVariable ("userId") Integer userId) {
		return userService.findTournamentsLeftForUser(userId);
	}
	
	@PutMapping("/api/user/{userId}/tournament/{tournamentId}")
	public int registerToTournament(@PathVariable ("userId") Integer userId
			, @PathVariable ("tournamentId") Integer tournamentId) {
		return userService.registerToTournament(userId, tournamentId);
	}
	
	@PutMapping("/api/user/{userId}/tournament/{tournamentId}/arbiter")
	public int registerAsArbiter(@PathVariable ("userId") Integer userId
			, @PathVariable ("tournamentId") Integer tournamentId) {
		return userService.registerAsArbiter(userId, tournamentId);
	}
	
	@DeleteMapping("/api/user/{userId}/tournament/{tournamentId}/arbiter")
	public int deregisterAsArbiter(@PathVariable ("userId") Integer userId
			, @PathVariable ("tournamentId") Integer tournamentId) {
		return userService.deregisterAsArbiter(userId, tournamentId);
	}
	
	@DeleteMapping("/api/user/{userId}/tournament/{tournamentId}")
	public int deregisterFromTournamement(@PathVariable ("userId") Integer userId
			, @PathVariable ("tournamentId") Integer tournamentId) {
		return userService.deregisterFromTournamement(userId, tournamentId);
	}
	
//	@PutMapping("/api/tournament/{tournamentId}/register")
//	public int registerToTournament(HttpSession session
//			, @PathVariable ("tournamentId") Integer tournamentId) {
//		if (session.getAttribute("user") != null) {
//			User u = (User) session.getAttribute("user");
//			return userService.registerToTournament(u.getId(), tournamentId);
//		}
//		return 0;
//	}
	
//	@DeleteMapping("/api/tournament/{tournamentId}/deregister")
//	public int deregisterFromTournamement(HttpSession session
//			, @PathVariable ("tournamentId") Integer tournamentId) {
//		if (session.getAttribute("user") != null) {
//			User u = (User) session.getAttribute("user");
//			return userService.deregisterFromTournamement(u.getId(), tournamentId);
//		}
//		return 0;
//	}
	
	@PostMapping("/api/users")
	public User createUser(HttpSession session, @RequestBody User u) {
		User user = userService.createUser(u);
//		if (user != null) {
//			session.setAttribute("user", user);
//		}
		return user;
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
