package com.jungleegames.game.server;

import com.jungleegames.auxiliary.database.entity.Player;

public interface TableService {

	
	public Player getPlayerData (String playerInfo);

	public void findAvailableTableORCreate(String player);

	public void removePlayer(String player);
}
