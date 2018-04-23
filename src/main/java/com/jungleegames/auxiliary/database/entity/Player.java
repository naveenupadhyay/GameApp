package com.jungleegames.auxiliary.database.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Player implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -908001465927465025L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String player;
	private Integer tableID;
	private String deviceID;
	private String status;
	public Player(String playerID, Integer tableID, String deviceID, String status) {
		super();
		this.player = playerID;
		this.tableID = tableID;
		this.deviceID = deviceID;
		this.status = status;
	}
	public String getPlayerID() {
		return player;
	}
	public void setPlayerID(String playerID) {
		this.player = playerID;
	}
	public Integer getTableID() {
		return tableID;
	}
	public void setTableID(Integer tableID) {
		this.tableID = tableID;
	}
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Player [player=" + player + ", tableID=" + tableID + ", status=" + status + "]";
	}
	
	
}
