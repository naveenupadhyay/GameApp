package com.jungleegames.game.server;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jungleegames.Message;

@Service("GameService")
public class GameServiceImpl implements GameService {

	
	@Autowired
	TableService tableService;
	
	@Override
	public void authenticate(Message message) {
		
		// authService.authenticate(message.getFrom(), message.getText());
	}

	@Override
	public void  joinTable(String player) {
	tableService.findAvailableTableORCreate(player);
		
	}

	@Override
	@Transactional
	public void disconnet(String player) {
//		authService.disconnect(player);
		tableService.removePlayer(player);

	}

}
