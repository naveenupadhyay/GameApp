package com.jungleegames.auxiliary.database;

import org.springframework.data.repository.CrudRepository;

import com.jungleegames.auxiliary.database.entity.Player;
/**
 * We are using Spring DATA JPA for communicating with the underlining db.
 * @author naveen.upadhyay
 *
 */
public interface PlayerRepository extends CrudRepository<Player, Long> {
	Player findByPlayer(String player);
}
