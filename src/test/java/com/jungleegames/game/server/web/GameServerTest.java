package com.jungleegames.game.server.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurationSupport;


/**
 * This test class logs in a few users. Ask them to join tables , checks if game starts and then disconnects them.
 * @author naveen.upadhyay
 *
 */

@WebAppConfiguration
public class GameServerTest {
	/*
	 * test here for connecting to this application using Stomp
	 */
	@Configuration
	static class WebSocketHandlerDecoratorConfig extends WebSocketMessageBrokerConfigurationSupport {

		@Override
		protected void registerStompEndpoints(StompEndpointRegistry registry) {
			registry.addEndpoint("/test");
		}
		
	}
}
