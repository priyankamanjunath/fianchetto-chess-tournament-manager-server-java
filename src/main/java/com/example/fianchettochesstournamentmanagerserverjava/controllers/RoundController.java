package com.example.fianchettochesstournamentmanagerserverjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fianchettochesstournamentmanagerserverjava.models.Round;
import com.example.fianchettochesstournamentmanagerserverjava.services.RoundService;

@RestController
@CrossOrigin(origins = "*")
public class RoundController {

	@Autowired
	RoundService roundService;
	
	@GetMapping("/api/rounds")
	public List<Round> findAllRounds() {
		return roundService.findAllRounds();
	}
	
//	@PostMapping("/api/rounds")
//	public Round createRound(@RequestBody Round r) {
//		return roundService.createRound(r);
//	}
	
	@PostMapping("/api/tournament/{tournamentId}/rounds")
	public Round createRound(@PathVariable ("tournamentId") Integer tournamentId) {
		return roundService.createRound(tournamentId);
	}
	
	@GetMapping("/api/round/{roundId}")
	public Round findRoundById(@PathVariable ("roundId") Integer roundId) {
		return roundService.findRoundById(roundId);
	}
	
	@DeleteMapping("/api/round/{roundId}")
	public void deleteRound(@PathVariable ("roundId") Integer roundId) {
		roundService.deleteRound(roundId);
	}
	
	@GetMapping("/api/tournament/{tournamentId}/rounds")
	public List<Round> findRoundsForTournament(@PathVariable ("tournamentId") Integer tournamentId) {
		return roundService.findRoundsForTournament(tournamentId);
	}
}
