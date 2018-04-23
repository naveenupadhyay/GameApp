package com.jungleegames.auxiliary.event;

import com.jungleegames.auxiliary.event.framework.Event;

public class PlayerDisconnectEvent implements Event {

	@Override
	public Class<? extends Event> getType() {
		return getClass();
	}

}
