package com.jungleegames.auxiliary.services;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service("ConcurrentTableManagerService")
public class ConcurrentTableManagerServiceImpl implements ConcurrentTableManagerService {
	
	ExecutorService service;
	
	@Autowired
	private  SimpMessageSendingOperations messagingTemplate;
	
	@PostConstruct
	void init() {
		service = Executors.newFixedThreadPool(50);

	}

	@Override
	public void submit(Runnable runnable) {
		service.execute(runnable);
		
	}
	

}
