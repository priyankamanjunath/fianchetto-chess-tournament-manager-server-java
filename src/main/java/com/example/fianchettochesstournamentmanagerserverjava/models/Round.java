package com.example.fianchettochesstournamentmanagerserverjava.models;

import java.util.List;

public class Round {
	private String id;
	private Tournament tournamentId;
	private List<Match> matchList;
	private List<User> playerList;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Tournament getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(Tournament tournamentId) {
		this.tournamentId = tournamentId;
	}
	public List<Match> getMatchList() {
		return matchList;
	}
	public void setMatchList(List<Match> matchList) {
		this.matchList = matchList;
	}
	public List<User> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(List<User> playerList) {
		this.playerList = playerList;
	}

}
