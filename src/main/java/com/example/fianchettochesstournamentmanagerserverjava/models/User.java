package com.example.fianchettochesstournamentmanagerserverjava.models;

import java.util.List;

public class User {
	
	private String id;
	private String name;
	private String email;
	private String password;
	
	private List<Tournament> tournamentList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Tournament> getTournamentList() {
		return tournamentList;
	}

	public void setTournamentList(List<Tournament> tournamentList) {
		this.tournamentList = tournamentList;
	}
}
