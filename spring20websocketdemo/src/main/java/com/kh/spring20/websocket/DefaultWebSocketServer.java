package com.kh.spring20.websocket;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 스프링에서 웹소켓 연결을 처리하는 도구(서버)
 * - 상속을 통해 구현(WebsocketHandler(I) / TextWebSocketHandler(C) / BinaryWebSocketHandler)(C)
 * - 등록하여 사용
 * - 스프링이 통신 관리는 전부 다 해주고, 진행 상태만 알려줌
 * - afterConnectionEstablished는 통신이 연결된 이후 실행되는 메소드
 * - afterConnectionClosed 통신이 종료된 이후 실행되는 메소드
 * */

@Service
@Slf4j
public class DefaultWebSocketServer extends TextWebSocketHandler{
	@Override
	//연결이 수립된 이후에 실행되는 메소드 
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.debug("사용자 접속!");
	}
	
	//연결이 종료된 이후 실행되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.debug("사용자 접속 종료");
	}
}
