package com.kh.spring20.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.kh.spring20.websocket.SockJsWebSocketServer;

//이 클래스는 생성한 웹소켓 서버를 어떤 주소에 할당하도록 설정하는 역할을 한다
@EnableWebSocket //중요(기본적으로 잠겨있음)
@Configuration
public class WebSocketServerConfiguration implements WebSocketConfigurer{

	@Autowired
	private SockJsWebSocketServer sockJsWebSocketServer;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		//SockJS를 사용하는 웹소켓 서버는 뒤에 추가적인 설정을 해야 한다.
		//- 클라이언트도 이 웹소켓 서버에 연결하려면 SockJS를 사용해야 한다
		registry.addHandler(sockJsWebSocketServer, "/ws/chat")
					.addInterceptors(new HttpSessionHandshakeInterceptor())
					.withSockJS(); //spring 표준
	}
}
