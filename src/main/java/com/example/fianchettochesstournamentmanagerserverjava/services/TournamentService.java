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
public class TournamentService {
	
	@Autowired
	TournamentRepository tournamentRepository;
	
	@Autowired
	UserRepository userRepository;
	
//	public Tournament createTournament(Tournament t) {
//		return tournamentRepository.save(t);
//	}
	
	public Tournament createTournament(Integer userId, Tournament t) {
		User u = userRepository.findById(userId).get();
		t.setMaster(u);
		return tournamentRepository.save(t);
	}
	
	public List<User> findPlayersForTournament(Integer tournamentId) {
		List<User> users = new ArrayList<>();
		for (UserTournament ut : tournamentRepository.findById(tournamentId).get().getPlayerList()) {
			users.add(ut.getPlayer());
		}
		return users;
	}
	
	public List<Tournament> findAllTournaments() {
		return (List<Tournament>) tournamentRepository.findAll();
	}
	
	public void deleteTournament(Integer tournamentId) {
		tournamentRepository.deleteById(tournamentId);
	}
	
	public Tournament findTournamentById(Integer tournamentId) {
		return tournamentRepository.findById(tournamentId).get();
	}
}
