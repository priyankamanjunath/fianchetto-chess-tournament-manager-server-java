package com.example.fianchettochesstournamentmanagerserverjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fianchettochesstournamentmanagerserverjava.models.Round;
import com.example.fianchettochesstournamentmanagerserverjava.repository.RoundRepository;

@Service
public class RoundService {
	
	@Autowired
	RoundRepository roundRepository;
	
	public Round createRound(Round r) {
		return roundRepository.save(r);
	}
	
	public List<Round> findAllRounds() {
		return (List<Round>) roundRepository.findAll();
	}
	
	public Round findRoundById(Integer roundId) {
		return roundRepository.findById(roundId).get();
	}
	
	public void deleteRound(Integer roundId) {
		roundRepository.deleteById(roundId);
	}
	
	public List<Round> findRoundsForTournament(Integer tournamentId) {
		return roundRepository.findRoundsForTournament(tournamentId);
	}
}
