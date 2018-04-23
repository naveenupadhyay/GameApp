package com.jungleegames.auxiliary.database;

import org.springframework.data.repository.CrudRepository;

import com.jungleegames.auxiliary.database.entity.Table;
/**
 *  We are using Spring DATA JPA for communicating with the underlining db.
 * @author naveen.upadhyay
 *
 */
public interface TableRepository extends CrudRepository<Table, Long> {
	Table findByCode(String code);
	

}
