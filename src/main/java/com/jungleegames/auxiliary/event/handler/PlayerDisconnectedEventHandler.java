package com.jungleegames.auxiliary.event.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

import com.jungleegames.auxiliary.database.entity.Player;
import com.jungleegames.auxiliary.database.entity.Table;
import com.jungleegames.auxiliary.event.PlayerDisconnectEvent;
import com.jungleegames.auxiliary.event.framework.EventDispatcher;
import com.jungleegames.auxiliary.event.framework.Handler;

@Component
public class PlayerDisconnectedEventHandler implements Handler<PlayerDisconnectEvent> {

	@Autowired
	private EventDispatcher dispatcher;

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	@Override
	public void onEvent(PlayerDisconnectEvent event) {
		Table table = event.getTable();
		String player = event.getPlayer();
		if(table.getAllocatedPlayers().size() == 0)
			return;
		for (Player p : table.getAllocatedPlayers())
			this.messagingTemplate.convertAndSendToUser(p.getPlayerID(), "/queue/user-updates",
				"Table" + table.getCode() + " Player Left: = " + player);
	}

}
