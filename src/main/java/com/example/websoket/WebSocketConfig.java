package com.example.websoket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Websocket Config
 *
 * @author zhang
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Enable a simple message broker and configure one or more prefixes to filter
     * destinations targeting the broker (e.g. destinations prefixed with "/topic").
     * topic is used to implement broadcast, and user is used to implement p2p.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
        messageBrokerRegistry.enableSimpleBroker("/topic", "/user");
    }


    /**
     * Register a STOMP over WebSocket endpoint at the given mapping path.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //mapping path is websocket and allowed origins
        stompEndpointRegistry.addEndpoint("/websocket").setAllowedOrigins("*").withSockJS();
    }
}
