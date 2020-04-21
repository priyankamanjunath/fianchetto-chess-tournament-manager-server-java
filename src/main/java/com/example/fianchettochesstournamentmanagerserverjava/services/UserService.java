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

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TournamentRepository tournamentRepository;
	
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	public int registerToTournament(Integer userId, Integer tournamentId) {
		User u = userRepository.findById(userId).get();
		if (u == null) {
			return 0;
		}
		Tournament t = tournamentRepository.findById(tournamentId).get();
		if (t.getMaster().getId() == userId) {
			return 0;
		}
		for (UserTournament ut : u.getTournamentList()) {
			if (ut.getTournament().getId() == tournamentId) {
				return 0;
			}
		}
		u.getTournamentList().add(new UserTournament(u, t));
		User user = userRepository.save(u);
		return (user != null) ? 1 : 0;
	}
	
	public int deregisterFromTournamement(Integer userId, Integer tournamentId) {
		return userRepository.deregister(userId, tournamentId);
	}
	
	public User login(User u) {
		User user = userRepository.loginUser(u.getEmail(), u.getPassword());
		if (user == null) {
			return new User(-1,"", "", "");
		}
		return user;
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
		User user = userRepository.findByEmail(u.getEmail());
		if (user == null) {
			return userRepository.save(u);
		}
		return new User(-1,"", "", "");
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
	
	public List<Tournament> findTournamentsLeftForUser(Integer userId) {
		List<Tournament> left = new ArrayList<>();
		List<Tournament> tournaments = findTournamentsForUser(userId);
		for (Tournament t : tournamentRepository.findAll()) {
			if (!tournaments.contains(t) && t.getMaster().getId() != userId) {
				left.add(t);
			}
		}
		return left;
	}

}
