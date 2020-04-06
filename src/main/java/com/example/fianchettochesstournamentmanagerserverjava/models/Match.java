package com.example.fianchettochesstournamentmanagerserverjava.models;

public class Match {
	
	private String id;
	private User player1;
	private User player2;
	private int result = 0;
	private Round round;
	
	public Match() {
		
	}

	public Match(String id, User player1, User player2, int result, Round round) {
		this.id = id;
		this.player1 = player1;
		this.player2 = player2;
		this.result = result;
		this.round = round;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
}
