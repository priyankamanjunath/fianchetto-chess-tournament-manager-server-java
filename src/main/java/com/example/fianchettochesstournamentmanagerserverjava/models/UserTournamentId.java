package com.example.fianchettochesstournamentmanagerserverjava.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserTournamentId implements Serializable {

	private static final long serialVersionUID = -2974279737103649419L;
	
	private Integer userId;
	
	private Integer tournamentId;
	
	
	public UserTournamentId() {
		
	}
	
	public UserTournamentId(Integer userId, Integer tournamentId) {
		super();
		this.userId = userId;
		this.tournamentId = tournamentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(Integer tournamentId) {
		this.tournamentId = tournamentId;
	}

}
