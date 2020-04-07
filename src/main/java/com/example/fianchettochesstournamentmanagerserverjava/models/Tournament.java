package com.example.fianchettochesstournamentmanagerserverjava.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tournaments")
public class Tournament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private boolean type;
	private String location;
	private int prize;
	private Date startDate;
	private Date endDate;
	private boolean inProgress;
//	private User winner;
//	private User master;
//	private List<User> playerList;
//	private List<Round> roundList;
	
	public Tournament() {
		
	}
	
	public Tournament(Integer id) {
		this.id = id;
	}
	
	public Tournament(Integer id, boolean type, String location, int prize, Date startDate, Date endDate,
			boolean inProgress, User winner, User master, List<User> playerList, List<Round> roundList) {
		this.id = id;
		this.type = type;
		this.location = location;
		this.prize = prize;
		this.startDate = startDate;
		this.endDate = endDate;
		this.inProgress = inProgress;
//		this.winner = winner;
//		this.master = master;
//		this.playerList = playerList;
//		this.roundList = roundList;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
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
//	public User getWinner() {
//		return winner;
//	}
//	public void setWinner(User winner) {
//		this.winner = winner;
//	}
//	public User getMaster() {
//		return master;
//	}
//	public void setMaster(User master) {
//		this.master = master;
//	}
//	public List<User> getPlayerList() {
//		return playerList;
//	}
//	public void setPlayerList(List<User> playerList) {
//		this.playerList = playerList;
//	}
//	public List<Round> getRoundList() {
//		return roundList;
//	}
//	public void setRoundList(List<Round> roundList) {
//		this.roundList = roundList;
//	}
	
	

}
