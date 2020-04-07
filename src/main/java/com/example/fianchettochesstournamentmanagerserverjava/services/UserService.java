package com.example.fianchettochesstournamentmanagerserverjava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fianchettochesstournamentmanagerserverjava.models.Tournament;
import com.example.fianchettochesstournamentmanagerserverjava.models.User;
import com.example.fianchettochesstournamentmanagerserverjava.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
//	public List<Tournament> findTournamentsForUser(String userId) {
//		for (User u : userList) {
//			if (u.getId().equals(userId)) {
//				return u.getTournamentList();
//			}
//		}
//		return null;
//	}
 	
	public User createUser(User u) {
//		userList.add(u);
//		return u;
		return null;
	}
	
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

	public User findUserById(Integer userId) {
		return userRepository.findById(userId).get();
	}

}
