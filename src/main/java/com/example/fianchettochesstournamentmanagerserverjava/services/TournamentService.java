package com.example.fianchettochesstournamentmanagerserverjava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fianchettochesstournamentmanagerserverjava.models.Tournament;
import com.example.fianchettochesstournamentmanagerserverjava.repository.TournamentRepository;

@Service
public class TournamentService {
	
	@Autowired
	TournamentRepository tournamentRepository;
	
	public Tournament createTournament(Tournament t) {
//		tournamentList.add(t);
//		return t;
		return null;
	}
	
//	public List<User> findPlayersForTournament(String tournamentId) {
//		for (Tournament t : tournamentList) {
//			if (t.getId().equals(tournamentId)) {
//				return t.getPlayerList();
//			}
//		}
//		return null;
//	}
	
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
