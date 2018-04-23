package com.jungleegames.auxiliary.event.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jungleegames.Constants;
import com.jungleegames.auxiliary.database.entity.Table;
import com.jungleegames.auxiliary.event.GameScheduledToStartEvent;
import com.jungleegames.auxiliary.event.GameStartEvent;
import com.jungleegames.auxiliary.event.framework.EventDispatcher;
import com.jungleegames.auxiliary.event.framework.Handler;

@Component
public class GameScheduledToStartEventHandler implements Handler<GameScheduledToStartEvent> {

	@Autowired
	private EventDispatcher dispatcher;
	@Override
	public void onEvent(GameScheduledToStartEvent event) {
		try {
			Thread.sleep(event.getNumSeconds() * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Table table = event.getTable();
		if (table.getAllocatedPlayers().size() >= 2 && (table.getStatus().equals(Constants.WAITING_FOR_PLAYERS))) {
			GameStartEvent event2 = new GameStartEvent(table);
			dispatcher.dispatch(event2);
		}
	}

}
