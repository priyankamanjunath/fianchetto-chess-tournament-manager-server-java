package com.example.fianchettochesstournamentmanagerserverjava.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String password;
	
	@ManyToMany
	@JoinTable(
			name = "user_tournament",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "tournament_id"))
	private List<Tournament> tournamentList = new ArrayList<>();
	
	public User() {
		
	}
	
	public User(Integer id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.tournamentList = new ArrayList<>();
	}
	
	public User(Integer id, String name, String email, String password, List<Tournament> tournamentList) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.tournamentList = tournamentList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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