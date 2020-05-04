package com.example.fianchettochesstournamentmanagerserverjava.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@Table(name = "userTournament")
public class UserTournament {
	
	@EmbeddedId
	private UserTournamentId id = new UserTournamentId();
	
	@ManyToOne
	@MapsId("userId")
	private User player;
	
	@ManyToOne
	@MapsId("tournamentId")
	private Tournament tournament;
	
	private Double points = 0.0;
	
	
	public UserTournament() {
		
	}
	
	public UserTournament(User player, Tournament tournament) {
		this.player = player;
		this.tournament = tournament;
	}

	public User getPlayer() {
		return player;
	}

	public void setPlayer(User player) {
		this.player = player;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}
}


