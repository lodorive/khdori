package com.kh.spring20.websocket;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring20.dao.ChatDao;
import com.kh.spring20.dto.ChatDto;
import com.kh.spring20.vo.ClientVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Service
public class SockJsWebSocketServer extends TextWebSocketHandler {
	
	//저장소
	//private Set<WebSocketSession> clients = new CopyOnWriteArraySet<>();
	private Set<ClientVO> clients = new CopyOnWriteArraySet<>();//전체 회원
	private Set<ClientVO> members = new CopyOnWriteArraySet<>();//로그인한 회원
	private Map<Integer, Set<ClientVO>> clubMembersMap = new ConcurrentHashMap<>(); // 동호회 멤버, 클럽 번호를 키로 사용
	
	//JSON 변환기
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private ChatDao chatDao;

	@Autowired
	private SqlSession sqlSession;
	
	//서버에 접속 성공
//	@Override
//	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//		ClientVO client = new ClientVO(session);
//		clients.add(client); //전체 회원에 넣음
//		
//		if(client.isMember()) { //아이디 레벨 둘 다 null이 아니면 
//			members.add(client); //로그인한 멤버에 넣음
//						
//			Integer clubNo = client.getClubNo();
//	        if (clubNo != null) {
//	            addClubMember(client, clubNo); // 클라이언트를 동호회 멤버 목록에 추가
//	        }
//	    }
//		
//	    log.debug("사용자 접속! 현재 {}명", clients.size());
//	    log.debug("접속한 사용자 = {}", client);
//
//	    // 모든 접속자에게 접속자 명단을 전송
//	    sendClientList();
//	    sendMessageList(client);
//
//	}
//
//	
//	@Override
//	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//		ClientVO client = new ClientVO(session);
//		clients.remove(client);
//		
//		if(client.isMember()) {
//			members.remove(client);
//		}
//				
//		
//		log.debug("사용자 종료! 현재 {}명", clients.size());
////		log.debug("종료 동호회멤버 = {}", clubMembers.size());
//		
//		//모든 접속자에게 접속자 명단을 전송
//		sendClientList();
//		sendMessageList(client);
//	}
	
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	    ClientVO client = new ClientVO(session);
	    clients.add(client); // 전체 회원에 추가

	    if (client.isMember()) {
	        members.add(client); // 로그인한 멤버에 추가
	        Integer clubNo = client.getClubNo();
	        if (clubNo != null) {
	            addClubMember(client, clubNo); // 클라이언트를 동호회 멤버 목록에 추가
	        }
	    }

	    log.debug("사용자 접속! 현재 {}명", clients.size());
	    log.debug("접속한 사용자 = {}", client);

	    // 모든 접속자에게 접속자 명단을 전송
	    sendMessageList(client);
	    sendClubMembersList(client.getClubNo()); // 동호회 멤버 명단 전송

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	    ClientVO client = new ClientVO(session);
	    clients.remove(client);

	    if (client.isMember()) {
	        members.remove(client); // 로그인한 멤버에서 제거
	        Integer clubNo = client.getClubNo();
	        if (clubNo != null) {
	            removeClubMember(client, clubNo); // 클라이언트를 동호회 멤버 목록에서 제거
	        }
	    }

	    log.debug("사용자 종료! 현재 {}명", clients.size());
	    
	    // 모든 접속자에게 접속자 명단을 전송
	    sendMessageList(client);
	    sendClubMembersList(client.getClubNo()); // 동호회 멤버 명단 전송
	}
	
	//동호회 멤버 추가
	public void addClubMember(ClientVO client, Integer clubNo) {
	    Set<ClientVO> clubMembers = clubMembersMap.computeIfAbsent(clubNo, k -> new HashSet<>());
	    clubMembers.add(client);
	    log.debug("동호회멤버 = {}", clubMembers.size());
	}
	//제거
	public void removeClubMember(ClientVO client, Integer clubNo) {
	    Set<ClientVO> clubMembers = clubMembersMap.get(clubNo);
	    if (clubMembers != null) {
	        clubMembers.remove(client);
	    }
	}
	
//	//접속자 명단(clients)을 모든 접속자에게 전송하는 메소드
//	public void sendClientList() throws IOException {
//		//1. clients를 전송 가능한 형태(JSON 문자열)로 변환한다
//		ObjectMapper mapper = new ObjectMapper();
//
//		Map<String, Object> data = new HashMap<>();
//		data.put("clients", clients);//로그인한 회원 명단
//		String clientJson = mapper.writeValueAsString(data);
//		
//		//2. 모든 사용자에게 전송
//		TextMessage message = new TextMessage(clientJson);
//		for(ClientVO client : clients) {
//			client.send(message);
//		}
//	}
	
	// 동호회 멤버 명단을 전송하는 메소드
	public void sendClubMembersList(Integer clubNo) throws IOException {
	    // 1. 동호회 멤버 명단을 전송 가능한 형태(JSON 문자열)로 변환한다
	    ObjectMapper mapper = new ObjectMapper();

	    Set<ClientVO> clubMembers = clubMembersMap.get(clubNo); // 클럽 번호에 해당하는 동호회 멤버 명단 가져오기

	    if (clubMembers != null) {
	        Map<String, Object> data = new HashMap<>();
	        data.put("clubMembers", clubMembers);
	        String clubMembersJson = mapper.writeValueAsString(data);

	        // 2. 동호회 멤버에게 전송
	        TextMessage message = new TextMessage(clubMembersJson);

	        for (ClientVO clubMember : clubMembers) {
	            clubMember.send(message);
	        }
	    }
	}

	
	
	//접속한 사용자에게 메세지 이력을 전송하는 메소드
	public void sendMessageList(ClientVO client) throws IOException {
		List<ChatDto> list = chatDao.list();
		
		for(ChatDto dto : list) {
			if(dto.getChatReceiver() == null && dto.getClubNo() == client.getClubNo()) {
				LocalDateTime chatTime = LocalDateTime.now(); // 현재 날짜와 시간 가져오기
					
					Map<String, Object> map = new HashMap<>();
					map.put("content", dto.getChatContent());
					map.put("memberId", dto.getChatSender());
					map.put("memberLevel", dto.getChatSenderLevel());
					map.put("chatTime", chatTime.toString()); // LocalDateTime을 문자열로 변환하여 추가
					map.put("memberNickname", dto.getChatSenderNickname());
					map.put("chatRoomNo", dto.getChatRoomNo());
					map.put("clubNo", dto.getClubNo());
	
					String messageJson = mapper.writeValueAsString(map);
					TextMessage message = new TextMessage(messageJson);
					client.send(message);					
			}
		}		
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//사용자가 보낸 메세지를 모두에게 broadcast
		ClientVO client = new ClientVO(session);
		if(client.isMember() == false) return; //비회원 리턴
		
		Integer clubNo = client.getClubNo();
		
		 if (clubNo != null) {
		        Set<ClientVO> clubMembers = clubMembersMap.get(clubNo); // 클럽 번호에 해당하는 동호회 멤버 명단 가져오기

		        if (clubMembers != null) {
		            // (+추가) 사용자는 메세지를 JSON 형태로 보내므로 이를 해석해야 한다(ObjectMapper)
		            Map params = mapper.readValue(message.getPayload(), Map.class);

		            LocalDateTime chatTime = LocalDateTime.now(); // 현재 날짜와 시간 가져오기

		            // 정보를 Map에 담아서 변환 후 전송
		            Map<String, Object> map = new HashMap<>();
		            map.put("memberId", client.getMemberId());
		            map.put("memberLevel", client.getMemberLevel());
		            map.put("content", params.get("content"));
		            map.put("chatTime", chatTime.toString()); // LocalDateTime을 문자열로 변환하여 추가
		            map.put("memberNickname", client.getMemberNickname());
		            map.put("chatRoomNo", client.getChatRoomNo());
		            map.put("clubNo", clubNo); // 사용자의 동호회 번호 사용

		            String messageJson = mapper.writeValueAsString(map);
		            TextMessage tm = new TextMessage(messageJson);

		            // 메세지 발송
		            for (ClientVO c : clubMembers) {
		                c.send(tm);
		            }

		            // DB insert (전체 메세지일 경우 내용, 발신자, 발신자등급을 저장)
		            chatDao.insert(ChatDto.builder()
		                    .chatContent((String) params.get("content"))
		                    .chatSender(client.getMemberId())
		                    .chatSenderLevel(client.getMemberLevel())
		                    .chatSenderNickname(client.getMemberNickname())
		                    .chatRoomNo(client.getChatRoomNo())
		                    .clubNo(clubNo) // 사용자의 동호회 번호 사용
		                    .build());
		        }
		    }
	    }
	}
						

	
	




