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
	
	@OneToOne
	private User home;
	
	private int homePoints;
	
	@OneToOne
	private User away;
	
	private int awayPoints;
	
	@ManyToOne
	private Round round;
	
	public Match() {
		
	}

	public Match(Integer id, User home, int homePoints, int awayPoints, User away, Round round) {
		this.id = id;
		this.home = home;
		this.away = away;
		this.homePoints = homePoints;
		this.awayPoints = awayPoints;
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
	public Round getRound() {
		return round;
	}
	public void setRound(Round round) {
		this.round = round;
	}

	public int getHomePoints() {
		return homePoints;
	}

	public void setHomePoints(int homePoints) {
		this.homePoints = homePoints;
	}

	public int getAwayPoints() {
		return awayPoints;
	}

	public void setAwayPoints(int awayPoints) {
		this.awayPoints = awayPoints;
	}
}
