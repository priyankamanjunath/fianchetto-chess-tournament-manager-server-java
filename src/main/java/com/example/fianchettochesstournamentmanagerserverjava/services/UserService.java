package com.example.fianchettochesstournamentmanagerserverjava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.fianchettochesstournamentmanagerserverjava.models.Tournament;
import com.example.fianchettochesstournamentmanagerserverjava.models.User;

public class UserService {
	
	List<User> userList = new ArrayList<>();
	
	{
		User w1 = new User("1", "Fenil", "fenil@abc.com", "12345", new ArrayList<Tournament>());
		User w2 = new User("2", "Jaynil", "jaynil@abc.com", "12345", new ArrayList<Tournament>());
		User w3 = new User("3", "Priyanka", "priyanka@abc.com", "12345", new ArrayList<Tournament>());
		User w4 = new User("4", "Akshay", "akshay@abc.com", "12345", new ArrayList<Tournament>());
		userList.add(w1);
		userList.add(w2);
		userList.add(w3);
		userList.add(w4);
	}
	
	public List<User> findAllUsers() {
		return userList;
	}
	
	public User createUser(User u) {
		userList.add(u);
		return u;
	}
	
	public void deleteUser(String userId) {
		userList = userList.stream()
				.filter(u -> !u.getId().equals(userId)).collect(Collectors.toList());
	}

	public User findUserById(String userId) {
		for (User u : userList) {
			if (u.getId().equals(userId)) {
				return u;
			}
		}
		return null;
	}

}
