package com.jungleegames.auxiliary.event;


import com.jungleegames.auxiliary.database.entity.Table;
import com.jungleegames.auxiliary.event.framework.Event;

public class PlayerDisconnectEvent implements Event {
	
	private String player;
	private Table table;
	
	public PlayerDisconnectEvent(String player, Table table) {
		super();
		this.player = player;
		this.table = table;
	}

	

	public String getPlayer() {
		return player;
	}



	public Table getTable() {
		return table;
	}



	@Override
	public Class<? extends Event> getType() {
		return getClass();
	}

}
