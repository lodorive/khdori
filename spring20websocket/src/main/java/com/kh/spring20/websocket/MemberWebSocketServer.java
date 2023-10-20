package com.kh.spring20.websocket;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberWebSocketServer extends TextWebSocketHandler{
	
	//저장소
	private Set<WebSocketSession> clients = new CopyOnWriteArraySet<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		clients.add(session);
		log.debug("session ={}", session.getAttributes());
		
		//session의 추가 정보(attributes)를 조사하여 HttpSession의 정보를 추출하여 사용
		Map<String, Object> attr = session.getAttributes();
		String memberId = (String) attr.get("name");
		String memberLevel = (String) attr.get("level");
		log.debug("아이디 = {}, 등급 = {}", memberId, memberLevel);
		
		log.debug("사용자 접속 = {}명", clients.size());
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		clients.remove(session);
		log.debug("사용자 종료 ={}명", clients.size());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//기존 HTTP 세션의 정보를 조회
		Map<String, Object> attr = session.getAttributes();
		String memberId = (String) attr.get("name");
		String memberLevel = (String) attr.get("level");
		
		if(memberId == null || memberLevel == null) { //비회원이라면
			return;
		}
		
		for(WebSocketSession client : clients) {
			client.sendMessage(message);
		}
	}
}
