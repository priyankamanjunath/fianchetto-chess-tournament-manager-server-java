 package com.example.fianchettochesstournamentmanagerserverjava.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fianchettochesstournamentmanagerserverjava.models.Tournament;
import com.example.fianchettochesstournamentmanagerserverjava.models.User;
import com.example.fianchettochesstournamentmanagerserverjava.models.UserTournament;
import com.example.fianchettochesstournamentmanagerserverjava.repository.TournamentRepository;
import com.example.fianchettochesstournamentmanagerserverjava.repository.UserRepository;
import com.example.fianchettochesstournamentmanagerserverjava.repository.UserTournamentRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserTournamentRepository userTournamentRepository; 
	
	@Autowired
	TournamentRepository tournamentRepository;
	
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	public int registerToTournament(Integer userId, Integer tournamentId) {
		User u = userRepository.findById(userId).get();
		Tournament t = tournamentRepository.findById(tournamentId).get();
		u.getTournamentList().add(new UserTournament(u, t));
		User user = userRepository.save(u);
		return (user != null) ? 1 : 0; 		
	}
	
	public int deregisterFromTournamement(Integer userId, Integer tournamentId) {
		User u = userRepository.findById(userId).get();
		Tournament t = tournamentRepository.findById(tournamentId).get();
		return userRepository.deregister(u.getId(), t.getId());
	}
	
	public User login(User u) {
		return userRepository.loginUser(u.getEmail(), u.getPassword());
	}
	
	public List<Tournament> findTournamentsForUser(Integer userId) {
		User u = userRepository.findById(userId).get();
		List<Tournament> tournaments = new ArrayList<>();
		for (UserTournament ut : u.getTournamentList()) {
			tournaments.add(ut.getTournament());
		}
		return tournaments;
	}
 	
	public User createUser(User u) {
		for (User user : userRepository.findAll()) {
			if (u.getEmail().equals(user.getEmail())) {
				return null;
			}
		}
		return userRepository.save(u);
	}
	
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

	public User findUserById(Integer userId) {
		return userRepository.findById(userId).get();
	}

	public Double findUserPointsForTournament(Integer userId, Integer tournamentId) {
		for (UserTournament ut: userRepository.findById(userId).get().getTournamentList()) {
			if (ut.getTournament().getId() == tournamentId) {
				return ut.getPoints();
			}
		}
		return 0.0;
	}

}
