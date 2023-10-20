package com.kh.spring20.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GroupWebSocketServer extends TextWebSocketHandler{
	//사용자를 저장할 수 있는 저장소
	//private Set<WebSocketSession> clients = new HashSet<>(); //동기화 처리가 안되어 있기 때문에 쓰면 안된다
	private Set<WebSocketSession> clients = new CopyOnWriteArraySet<>(); //동기화 처리 됨
//	private Set<WebSocketSession> clients = Collections.synchronizedSet(new HashSet<>()); 위랑 둘 중 사용
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//사용자를 저장소에 추가하는 코드
		clients.add(session);
		log.debug("사용자 접속! 현재 {}명", clients.size());
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//사용자를 저장소에서 제거하는 코드
		clients.remove(session);
		log.debug("사용자 접속 종료! 현재 {}명", clients.size());
	}
}
