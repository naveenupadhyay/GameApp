package com.jungleegames.auxiliary.event;

import com.jungleegames.auxiliary.database.entity.Table;
import com.jungleegames.auxiliary.event.framework.Event;

public class GameStartEvent implements Event {

	Table table ;
	public GameStartEvent(Table table) {
		this.table = table;
	}

	
	public Table getTable() {
		return table;
	}


	@Override
	public Class<? extends Event> getType() {
		return getClass();
	}

}
