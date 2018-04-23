package com.jungleegames.game.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jungleegames.Constants;
import com.jungleegames.auxiliary.database.entity.Player;
import com.jungleegames.auxiliary.database.entity.Table;
import com.jungleegames.auxiliary.event.GameScheduledToStartEvent;
import com.jungleegames.auxiliary.event.framework.EventDispatcher;
import com.jungleegames.auxiliary.services.ConcurrentTableManagerService;

@Service("TableService ")
public class TableServiceImpl implements TableService {
	Map<Player, Table> playerTableMapping = new HashMap<Player, Table>();
	Set<Table> tables = new HashSet<Table>();

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;


	@Autowired
	private ConcurrentTableManagerService concurrentTableService;
	
	@Autowired
	private EventDispatcher dispatcher;

	private static final Logger LOG = LoggerFactory.getLogger(TableServiceImpl.class);


	@Override
	public Player getPlayerData(String playerInfo) {
		// fetch player information previously loaded into the database.
		// PlayerData player = new PlayerData(playerInfo, "TABLE1", "IPHONE1111, ")
		return null;
	}

	@Override
	public void findAvailableTableORCreate(String player) {
		// TODO: Query the db layer.For now using the inmemory set.
		Table t = null;
		Player p = null;
		if (tables.isEmpty()) {
			t = new Table("Table1");
			p = new Player(player, t.getId(), null, Constants.WAITING_FOR_PLAYERS);
			t.getAllocatedPlayers().add(p);
			t.setStatus(Constants.WAITING_FOR_PLAYERS);
			tables.add(t);
		} else {
			for (Table table : this.tables) {
				if (table.getStatus().equals(Constants.WAITING_FOR_PLAYERS)) {
					p = new Player(player, table.getId(), null, Constants.WAITING_FOR_PLAYERS);
					table.getAllocatedPlayers().add(p);
					t = table;
					break;
				}
			}
			if (t == null) {
				t = new Table("Table" + tables.size() + 1);
				p = new Player(player, t.getId(), null, Constants.WAITING_FOR_PLAYERS);
				t.getAllocatedPlayers().add(p);
				t.setStatus(Constants.WAITING_FOR_PLAYERS);
				tables.add(t);
			}
		}
		playerTableMapping.put(p, t);
		this.messagingTemplate.convertAndSendToUser(player, "/queue/user-updates", t.toString());
		checkForEvents(t);
	}

	private void checkForEvents(Table table) {
		if (table.getAllocatedPlayers().size() >= 2 && (table.getStatus().equals(Constants.WAITING_FOR_PLAYERS))) {
			GameScheduledToStartEvent event = new GameScheduledToStartEvent(table, 5);
			dispatcher.dispatch(event);
		}
	}

	//@Scheduled(fixedDelay = 1000)
	public void sendGameStartNotifications() {
		LOG.info("Scheduler running");
		for (Table table : this.tables) {
			if (table.getAllocatedPlayers().size() >= 2 && (table.getStatus().equals(Constants.WAITING_FOR_PLAYERS))) {
//				concurrentTableService.submit(new Runnable() {
//
//					@Override
//					public void run() {
//
//						Set<Player> players = table.getAllocatedPlayers();
//						for (Player p : players) {
//							messagingTemplate.convertAndSendToUser(p.getPlayerID(), "/queue/user-updates",
//									"Game Starting in 5 seconds");
//						}
//						try {
//							Thread.sleep(5000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						if (table.getAllocatedPlayers().size() >= 2) {
//							table.setStatus(Constants.IN_GAME);
//						}
//					}
//				});
//				for (Player player : table.getAllocatedPlayers())
//					this.messagingTemplate.convertAndSendToUser(player.getPlayerID(), "/queue/user-updates",
//							"Table" + table.getCode() + " Status: = " + table.getStatus());
			}
		}

	}

	@Override
	public void removePlayer(String player) {

	}

}
