package com.jungleegames.game.server;

import com.jungleegames.Message;

public interface GameService {

	void authenticate(Message message);

	void joinTable(String player);

	void disconnet(String player);

}
