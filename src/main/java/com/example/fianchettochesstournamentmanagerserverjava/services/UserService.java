package com.example.fianchettochesstournamentmanagerserverjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fianchettochesstournamentmanagerserverjava.models.Tournament;
import com.example.fianchettochesstournamentmanagerserverjava.models.User;
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
		Tournament t = tournamentRepository.findById(tournamentId).get();
		if (!u.getTournamentList().contains(t) && !t.getMaster().equals(u)) {
			u.getTournamentList().add(t);
			userRepository.save(u);
			return 1;
		}
		return 0;
		
	}
	
	public int deregisterFromTournamement(Integer userId, Integer tournamentId) {
		User u = userRepository.findById(userId).get();
		Tournament t = tournamentRepository.findById(tournamentId).get();
		if (u.getTournamentList().contains(t)) {
			u.getTournamentList().remove(t);
			userRepository.save(u);
			return 1;
		}
		return 0;
	}
	
	public User login(User u) {
		User user;
		if ((user = userRepository.findUserByEmail(u.getEmail())) != null) {
			if (user.getPassword().equals(u.getPassword())) {
				return user;
			}
		}
		return null;
	}
	
	public List<Tournament> findTournamentsForUser(Integer userId) {
		for (User u : userRepository.findAll()) {
			if (u.getId().equals(userId)) {
				return u.getTournamentList();
			}
		}
		return null;
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

}
