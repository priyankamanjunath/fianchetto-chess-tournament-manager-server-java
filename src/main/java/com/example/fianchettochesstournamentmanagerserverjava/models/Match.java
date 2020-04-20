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
	
	@ManyToOne
	private User home;
	
	@ManyToOne
	private User away;
	
	@ManyToOne
	private User arbiter = null;
	
	private int result = -9;
	
	@ManyToOne
	private Round round;
	
	public Match() {
		
	}

	public Match(Integer id, User home, int result, User away, Round round) {
		this.id = id;
		this.home = home;
		this.away = away;
		this.result = result;
		this.round = round;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getHome() {
		return home;
	}
	public void setHome(User home) {
		this.home = home;
	}
	public User getAway() {
		return away;
	}
	public void setAway(User away) {
		this.away = away;
	}
	public User getArbiter() {
		return arbiter;
	}

	public void setArbiter(User arbiter) {
		this.arbiter = arbiter;
	}

	public Round getRound() {
		return round;
	}
	public void setRound(Round round) {
		this.round = round;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
