package com.example.fianchettochesstournamentmanagerserverjava.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rounds")
public class Round {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JsonIgnore
	private Tournament tournament;
	
//	private List<Match> matchList;
	@OneToMany
	private List<User> playerList;
	
	public Round() {
		
	}
	
	public Round(Integer id, Tournament tournament, List<Match> matchList, List<User> playerList) {
		this.id = id;
		this.tournament = tournament;
//		this.matchList = matchList;
		this.playerList = playerList;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Tournament getTournamentId() {
		return tournament;
	}
	public void setTournamentId(Tournament tournament) {
		this.tournament = tournament;
	}
//	public List<Match> getMatchList() {
//		return matchList;
//	}
//	public void setMatchList(List<Match> matchList) {
//		this.matchList = matchList;
//	}
	public List<User> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(List<User> playerList) {
		this.playerList = playerList;
	}

}
