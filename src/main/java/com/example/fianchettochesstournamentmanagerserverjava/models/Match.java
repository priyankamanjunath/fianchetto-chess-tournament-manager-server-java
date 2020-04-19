package com.example.fianchettochesstournamentmanagerserverjava.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "matches")
public class Match {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@OneToOne
	private User player1;
	
	@OneToOne
	private User player2;
	
	private int result = -9;
	
	@ManyToOne
	private Round round;
	
	public Match() {
		
	}

	public Match(Integer id, User player1, User player2, int result, Round round, String name) {
		this.id = id;
		this.player1 = player1;
		this.player2 = player2;
		this.result = result;
		this.round = round;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getPlayer1() {
		return player1;
	}
	public void setPlayer1(User player1) {
		this.player1 = player1;
	}
	public User getPlayer2() {
		return player2;
	}
	public void setPlayer2(User player2) {
		this.player2 = player2;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Round getRound() {
		return round;
	}
	public void setRound(Round round) {
		this.round = round;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
