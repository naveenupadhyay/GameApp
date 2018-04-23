package com.jungleegames.game.server.web;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.jungleegames.Constants;
import com.jungleegames.Message;
import com.jungleegames.game.server.GameService;
import com.jungleegames.game.server.TableService;

@Controller
public class GameServerController {
	
	@Autowired
	TableService tableService;
	
	@Autowired 
	GameService gameService;

	 private static final Logger LOG = LoggerFactory.getLogger(GameServerController.class);

	   
	@MessageMapping("/chat")
	public void send(Message message,  Principal principal) throws Exception {
		LOG.info("received message {} ",message);
		message.setFrom(principal.getName());
		String player = message.getFrom();
		String messageType = message.getMsgType();
		 if (messageType.equals(Constants.JOIN_TABLE)) {
			 gameService.joinTable(player);
		}else if(messageType.equalsIgnoreCase(Constants.DISCONNET)) {
			gameService.disconnet(player);
		}
	}
}
