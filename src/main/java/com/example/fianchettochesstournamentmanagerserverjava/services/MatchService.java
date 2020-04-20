package com.example.fianchettochesstournamentmanagerserverjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fianchettochesstournamentmanagerserverjava.models.Match;
import com.example.fianchettochesstournamentmanagerserverjava.models.Round;
import com.example.fianchettochesstournamentmanagerserverjava.models.Tournament;
import com.example.fianchettochesstournamentmanagerserverjava.repository.MatchRepository;
import com.example.fianchettochesstournamentmanagerserverjava.repository.RoundRepository;
import com.example.fianchettochesstournamentmanagerserverjava.repository.TournamentRepository;
import com.example.fianchettochesstournamentmanagerserverjava.repository.UserRepository;

@Service
public class MatchService {

	@Autowired
	MatchRepository matchRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TournamentRepository tournamentRepository;
	
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
		m.setHome(userRepository.findById(m.getHome().getId()).get());
		m.setAway(userRepository.findById(m.getAway().getId()).get());
		return matchRepository.save(m);
	}
	
	public List<Match> findMatchesForUser(Integer userId) {
		return matchRepository.findMatchesForUser(userId);
	}

	public List<Match> findUserMatchesForTournament(Integer userId, Integer tournamentId) {
		return matchRepository.findUserMatchesForTournament(userId, tournamentId);
	}
	
	public int updateMatchResult(Integer matchId, Match match) {
		if (matchId == match.getId()) {
			Match m = matchRepository.findById(matchId).get();
			Round r = roundRepository.findById(m.getRound().getId()).get();
			if (m.getResult() != -9) {
				switch (m.getResult()) {
					case 1:
						matchRepository.updatePoints(m.getHome().getId(),r.getTournament().getId(), -1.0);
						break;
						
					case -1:
						matchRepository.updatePoints(m.getAway().getId(), r.getTournament().getId(), -1.0);
						break;
						
					case 0:
						matchRepository.updatePoints(m.getHome().getId(), r.getTournament().getId(), -0.5);
						matchRepository.updatePoints(m.getAway().getId(), r.getTournament().getId(), -0.5);
						break;
				}
			}
			matchRepository.updateMatchResult(matchId, match.getResult());
			switch (match.getResult()) {
				case 1:
					matchRepository.updatePoints(m.getHome().getId(),r.getTournament().getId(), 1.0);
					break;
					
				case -1:
					matchRepository.updatePoints(m.getAway().getId(), r.getTournament().getId(), 1.0);
					break;
					
				case 0:
					matchRepository.updatePoints(m.getHome().getId(), r.getTournament().getId(), 0.5);
					matchRepository.updatePoints(m.getAway().getId(), r.getTournament().getId(), 0.5);
					break;
			}
			return 1;
		}
		return 0;
	}
	
	public int updateMatchResults(List<Match> matches) {
		for (Match m : matches) {
			updateMatchResult(m.getId(), m);
		}
		
		return 1;
	}

	public String findAllMatchesForTournament(Integer tournamentId) {
		Tournament t = tournamentRepository.findById(tournamentId).get();
		String result = "";
		int round = 0;
		for (Round r : t.getRoundList()) {
			round++;
			for (Match m: r.getMatchList()) {
				result += "{"
						+ "\"round\": \"" + round + "\","
						+ "\"home\": {\"id\": \"" + m.getHome().getId() + "\", \"points\": \"" +
						matchRepository.getPoints(m.getHome().getId(), tournamentId) + "\"},"
						+ "\"away\": {\"id\": \"" + m.getAway().getId() + "\", \"points\": \"" + 
						matchRepository.getPoints(m.getAway().getId(), tournamentId) + "\"}"
						+ "},";
			}
		}
		return (!result.equals("")) ? result.substring(0, result.length() - 1) : "";
	}
	
}
