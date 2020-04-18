package com.example.fianchettochesstournamentmanagerserverjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fianchettochesstournamentmanagerserverjava.models.Round;
import com.example.fianchettochesstournamentmanagerserverjava.models.Tournament;
import com.example.fianchettochesstournamentmanagerserverjava.models.User;
import com.example.fianchettochesstournamentmanagerserverjava.repository.TournamentRepository;

@Service
public class TournamentService {
	
	@Autowired
	TournamentRepository tournamentRepository;
	
//	@Autowired
//	UserRepository userRepository;
	
	public Tournament createTournament(Tournament t) {
		return tournamentRepository.save(t);
	}
	
//	public Tournament createTournament(Integer userId, Tournament t) {
//		User u = userRepository.findById(userId).get();
//		u.setTournamentList(u.getTournamentList().add(t));
//		userRepository.save(u);
//		return tournamentRepository.save(t);
//	}
	
	public List<User> findPlayersForTournament(Integer tournamentId) {
		for (Tournament t : tournamentRepository.findAll()) {
			if (t.getId().equals(tournamentId)) {
				return t.getPlayerList();
			}
		}
		return null;
	}
	
	public List<Round> findRoundsForTournament(Integer tournamentId) {
		for (Tournament t : tournamentRepository.findAll()) {
			if (t.getId().equals(tournamentId)) {
				return t.getRoundList();
			}
		}
		return null;
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
