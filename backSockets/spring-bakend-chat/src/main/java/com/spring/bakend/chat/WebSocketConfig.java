package com.spring.bakend.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {

		registry.addEndpoint("/chatwebsocket").setAllowedOrigins("http://localhost:4200").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
//		nombre del evento al cual los clientes se subscriben
		registry.enableSimpleBroker("/chat/");
//		destino donde se publica
		registry.setApplicationDestinationPrefixes("/app");
	}

}
