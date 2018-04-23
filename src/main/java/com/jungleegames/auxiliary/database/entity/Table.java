package com.jungleegames.auxiliary.database.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

public class Table implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6949708260156929405L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	private String code;
	private Set<Player> allocatedPlayers = new HashSet<>();
	private String status;
	
	public Table() {
		
	}
	public Table(String code) {
		this.code = code;
	}
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Set<Player> getAllocatedPlayers() {
		return allocatedPlayers;
	}
	public void setAllocatedPlayers(Set<Player> allocatedPlayers) {
		this.allocatedPlayers = allocatedPlayers;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Table [id=" + id + ", code=" + code + ", allocatedPlayers=" + allocatedPlayers + ", status=" + status
				+ "]";
	}

	
	
//	sendBroadcast() ;
//	sendMsg(Player p);
}
