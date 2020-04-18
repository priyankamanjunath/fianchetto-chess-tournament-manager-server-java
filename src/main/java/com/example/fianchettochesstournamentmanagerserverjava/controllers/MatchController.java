package com.example.fianchettochesstournamentmanagerserverjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fianchettochesstournamentmanagerserverjava.models.Match;
import com.example.fianchettochesstournamentmanagerserverjava.services.MatchService;

@RestController
@CrossOrigin(origins = "*")
public class MatchController {
	
	@Autowired
	MatchService matchService;
	
	@GetMapping("/api/matches")
	public List<Match> findAllRounds() {
		return matchService.findAllMatches();
	}
	
	@PostMapping("/api/matches")
	public Match createRound(@RequestBody Match m) {
		return matchService.createMatch(m);
	}
	
	@GetMapping("/api/match/{matchId}")
	public Match findRoundById(@PathVariable ("matchId") Integer roundId) {
		return matchService.findMatchById(roundId);
	}
	
	@DeleteMapping("/api/match/{matchId}")
	public void deleteRound(@PathVariable ("matchId") Integer roundId) {
		matchService.deleteMatch(roundId);
	}
}
