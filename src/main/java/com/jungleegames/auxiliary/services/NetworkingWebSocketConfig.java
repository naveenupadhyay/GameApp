package com.jungleegames.auxiliary.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * This class manager networking needs.
 * Essentially all clients will establish websocket connections with the game server so that duplex communication
 * can happen.
 * @author naveen.upadhyay
 *
 */
@Configuration
@EnableScheduling
@EnableWebSocketMessageBroker
public class NetworkingWebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
 
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic", "/queue"); //to enable a simple memory-based message broker 
        config.setApplicationDestinationPrefixes("/app"); //"/app" prefix for messages that are bound for @MessageMapping-annotated methods. 
    }
 
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
         registry.addEndpoint("/chat");
         registry.addEndpoint("/chat").withSockJS();
    }
}
