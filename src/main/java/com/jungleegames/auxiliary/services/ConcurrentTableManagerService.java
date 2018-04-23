package com.jungleegames.auxiliary.services;

public interface ConcurrentTableManagerService {

	void submit(Runnable runnable);

}
