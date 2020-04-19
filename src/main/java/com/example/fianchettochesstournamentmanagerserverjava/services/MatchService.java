package com.example.fianchettochesstournamentmanagerserverjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fianchettochesstournamentmanagerserverjava.models.Match;
import com.example.fianchettochesstournamentmanagerserverjava.models.Round;
import com.example.fianchettochesstournamentmanagerserverjava.repository.MatchRepository;
import com.example.fianchettochesstournamentmanagerserverjava.repository.RoundRepository;

@Service
public class MatchService {

	@Autowired
	MatchRepository matchRepository;
	
	@Autowired
	RoundRepository roundRepository;
	
	public Match createMatch(Match m) {
		return matchRepository.save(m);
	}
	
	public List<Match> findAllMatches() {
		return (List<Match>) matchRepository.findAll();
	}
	
	public Match findMatchById(Integer matchId) {
		return matchRepository.findById(matchId).get();
	}
	
	public void deleteMatch(Integer matchId) {
		matchRepository.deleteById(matchId);
	}

	public List<Match> findMatchesForRound(Integer roundId) {
		return matchRepository.findMatchesForRound(roundId);
	}

	public Match createMatch(Match m, Integer roundId) {
		m.setRound(roundRepository.findById(roundId).get());
		return matchRepository.save(m);
	}
	
	public List<Match> findMatchesForUser(Integer userId) {
		return matchRepository.findMatchesForUser(userId);
	}

	public List<Match> findUserMatchesForTournament(Integer userId, Integer tournamentId) {
		return matchRepository.findUserMatchesForTournament(userId, tournamentId);
	}
	
	public int updateMatchResults(List<Match> matches) {
		for (Match m : matches) {
			System.out.println(m.getId() + " " + m.getResult());
			matchRepository.updateMatchResults(m.getId(), m.getResult());
		}
		return 1;
	}
	
}
