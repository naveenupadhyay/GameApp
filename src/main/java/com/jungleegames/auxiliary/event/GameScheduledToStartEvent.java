package com.jungleegames.auxiliary.event;

import com.jungleegames.auxiliary.database.entity.Table;
import com.jungleegames.auxiliary.event.framework.Event;

public class GameScheduledToStartEvent implements Event {

	private Table table;
	private int numSeconds;
	public GameScheduledToStartEvent(Table table, int i) {
		this.table = table;
		this.numSeconds = i;
	}

	public Table getTable() {
		return table;
	}


	public int getNumSeconds() {
		return numSeconds;
	}


	@Override
	public Class<? extends Event> getType() {
		return getClass();
	}

}
