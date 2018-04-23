package com.jungleegames.auxiliary.event.handler;

import org.springframework.stereotype.Component;

import com.jungleegames.auxiliary.event.JoinTableEvent;
import com.jungleegames.auxiliary.event.framework.Handler;

@Component
public class JoinTableEventHandler implements Handler<JoinTableEvent> {

	@Override
	public void onEvent(JoinTableEvent event) {

	}
}
