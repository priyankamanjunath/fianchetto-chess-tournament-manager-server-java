package com.example.fianchettochesstournamentmanagerserverjava.controllers;

import java.util.ArrayList;
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

/**
 * The commented APIs can be used for implementing session.
 * @author fenilshah
 *
 */
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
	
//	@GetMapping("/api/tournaments")
//	public List<Tournament> findTournamentsForUser (HttpSession session) {
//		if (session.getAttribute("user") != null) {
//			int id = ((User) session.getAttribute("user")).getId();
//			return userService.findTournamentsForUser(id);
//		}
//		return new ArrayList<>();
//	}

	
	@PostMapping("/api/login")
	public User login(HttpSession session, @RequestBody User u) {
		User user = userService.login(u);
		return user;
	}
	
//	@PostMapping("/api/login")
//	public User login(HttpSession session, @RequestBody User u) {
//		User user = userService.login(u);
//		if (user != null) {
//			session.setAttribute("user", user);
//		}
//		user.setPassword("***");
//		return user;
//	}
	
//	@PostMapping("/api/logout")
//	public void logout(HttpSession session) {
//		session.invalidate();
//	}
	
//	@PostMapping("/api/user")
//	public User getCurrentUser(HttpSession session) {
//		if (session.getAttribute("user") != null) {
//			return (User) session.getAttribute("user");
//		}
//		User u = new User();
//		u.setId(-1);
//		return u;
//	}
	
	@PutMapping("/api/user/{userId}")
	public User updateInfo(@PathVariable("userId") Integer id ,@RequestBody User u) {
		return userService.updateInfo(id, u);
	}
	
	@GetMapping("/api/user/{userId}/tournament/{tournamentId}")
	public Double findUserPointsForTournament(@PathVariable("userId") Integer userId, @PathVariable("tournamentId") Integer tournamentId) {
		return userService.findUserPointsForTournament(userId, tournamentId);
	}
	
//	@GetMapping("/api/tournament/{tournamentId}/points")
//	public Double findUserPointsForTournament(HttpSession session, @PathVariable("tournamentId") Integer tournamentId) {
//		if (session.getAttribute("user") != null) {
//			int id = ((User) session.getAttribute("user")).getId();
//			return userService.findUserPointsForTournament(id, tournamentId);
//		}
//		return -1.0;
//	}
	
	@GetMapping("/api/user/{userId}/tournamentsLeft")
	public List<Tournament> findTournamentsLeftForUser(@PathVariable ("userId") Integer userId) {
		return userService.findTournamentsLeftForUser(userId);
	}
	
//	@GetMapping("/api/tournamentsLeft")
//	public List<Tournament> findTournamentsLeftForUser(HttpSession session) {
//		if (session.getAttribute("user") != null) {
//			int id = ((User) session.getAttribute("user")).getId();
//			return userService.findTournamentsLeftForUser(id);
//		}
//		return (List<Tournament>) tournamentRepository.findAll();
//	}
	
	@PutMapping("/api/user/{userId}/tournament/{tournamentId}")
	public int registerToTournament(@PathVariable ("userId") Integer userId
			, @PathVariable ("tournamentId") Integer tournamentId) {
		return userService.registerToTournament(userId, tournamentId);
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
	
	@DeleteMapping("/api/user/{userId}/tournament/{tournamentId}")
	public int deregisterFromTournamement(@PathVariable ("userId") Integer userId
			, @PathVariable ("tournamentId") Integer tournamentId) {
		return userService.deregisterFromTournamement(userId, tournamentId);
	}
	
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
		return user;
	}
	
//	@PostMapping("/api/users")
//	public User createUser(HttpSession session, @RequestBody User u) {
//		User user = userService.createUser(u);
//		if (user != null) {
//			session.setAttribute("user", user);
//		}
//		user.setPassword("***");
//		return user;
//	}
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable ("userId") Integer userId) {
		userService.deleteUser(userId);
	}
	
	@GetMapping("/api/users")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}
	

}
