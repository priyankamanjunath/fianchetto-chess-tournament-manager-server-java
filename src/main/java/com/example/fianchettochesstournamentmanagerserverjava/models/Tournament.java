package com.example.fianchettochesstournamentmanagerserverjava.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tournaments")
public class Tournament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String location;
	private int prize;
	private Date startDate = new Date();
	private Date endDate = new Date();
	private String description = null;
	private boolean inProgress = true;
	
	@OneToOne
	private User winner;
	
	@OneToOne
	private User master;

	@ManyToMany(mappedBy = "tournamentList")
	@JsonIgnore
	private List<User> playerList = new ArrayList<>();
	
	@OneToMany(mappedBy = "tournament")
	@JsonIgnore
	private List<Round> roundList;
	
	public Tournament() {
		
	}
	
	public Tournament(String name, String description, String location, int prize, Date startDate, Date endDate,
			boolean inProgress, User winner, User master, List<User> playerList, List<Round> roundList) {
		this.name = name;
		this.location = location;
		this.prize = prize;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.inProgress = inProgress;
		this.winner = winner;
		this.master = master;
		this.playerList = playerList;
		this.roundList = roundList;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isInProgress() {
		return inProgress;
	}
	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}
	public User getWinner() {
		return winner;
	}
	public void setWinner(User winner) {
		this.winner = winner;
	}
	public User getMaster() {
		return master;
	}
	public void setMaster(User master) {
		this.master = master;
	}
	public List<User> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(List<User> playerList) {
		this.playerList = playerList;
	}
	public List<Round> getRoundList() {
		return roundList;
	}
	public void setRoundList(List<Round> roundList) {
		this.roundList = roundList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
