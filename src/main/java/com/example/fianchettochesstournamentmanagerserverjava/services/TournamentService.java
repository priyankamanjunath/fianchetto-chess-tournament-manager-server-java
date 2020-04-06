package com.example.fianchettochesstournamentmanagerserverjava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.fianchettochesstournamentmanagerserverjava.models.Tournament;

public class TournamentService {
	
	List<Tournament> tournamentList = new ArrayList<>();
	
	{
		Tournament t1 = new Tournament("t1");
		Tournament t2 = new Tournament("t2");
		Tournament t3 = new Tournament("t3");
		Tournament t4 = new Tournament("t4");
		Tournament t5 = new Tournament("t5");
		tournamentList.add(t1);
		tournamentList.add(t2);
		tournamentList.add(t3);
		tournamentList.add(t4);
		tournamentList.add(t5);
	}

	public Tournament createTournament(Tournament t) {
		tournamentList.add(t);
		return null;
	}
	
	public List<Tournament> findAllTournaments() {
		return tournamentList;
	}
	
	public void deleteTournament(String tournamentId) {
		tournamentList = tournamentList.stream()
				.filter(t -> !t.getId().equals(tournamentId)).collect(Collectors.toList());
				
	}
	
	public Tournament findTournamentById(String tournamentId) {
		for (Tournament t: tournamentList) {
			if (t.getId().equals(tournamentId)) {
				return t;
			}
		}
		return null;
	}

}
