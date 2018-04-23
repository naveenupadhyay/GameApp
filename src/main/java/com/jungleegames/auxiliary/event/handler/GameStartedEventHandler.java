package com.jungleegames.auxiliary.event.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

import com.jungleegames.Constants;
import com.jungleegames.auxiliary.database.entity.Player;
import com.jungleegames.auxiliary.database.entity.Table;
import com.jungleegames.auxiliary.event.GameStartEvent;
import com.jungleegames.auxiliary.event.framework.Handler;

@Component
public class GameStartedEventHandler implements Handler<GameStartEvent> {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@Override
	public void onEvent(GameStartEvent event) {
		Table table = event.getTable();
		table.setStatus(Constants.IN_GAME);
		for (Player player : table.getAllocatedPlayers())
			this.messagingTemplate.convertAndSendToUser(player.getPlayerID(), "/queue/user-updates",
				"Table" + table.getCode() + " Status: = " + table.getStatus());

	}

}
