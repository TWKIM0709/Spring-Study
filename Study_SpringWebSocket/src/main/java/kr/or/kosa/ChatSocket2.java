package kr.or.kosa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatSocket2 extends TextWebSocketHandler{
	private static 	List<WebSocketSession> list = new ArrayList<WebSocketSession>();
	
	//연결 되었을 때 실행되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
//		System.out.println("하나의 클라이언트가 연결 됨 session" + session);
		sysoSession(session);
	}
	
	// 메세지를 보낼 때 호출되는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg = message.getPayload();//메세지를 받아서

		System.out.println("toString >> " + message.toString());
		System.out.println("payload >> " + message.getPayload());
		System.out.println(message.getClass().toString());
		
		for(WebSocketSession s : list) {	//접속중인 모든 세선에 전송
			s.sendMessage(message);
		}
		System.out.println("==session==");
		System.out.println(session);
		System.out.println("==message==");
		System.out.println(message);
		System.out.println("==msg==");
		System.out.println(msg);
		

		sysoSession(session);
	}
	// 연결 끊었을 때 실행되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결 해제됨");
		sysoSession(session);
		list.remove(session);
	}
	public void sysoSession(WebSocketSession session) {
		System.out.println("=================================================================================");
		System.out.println("session >> " + session);
		System.out.println("getAcceptedProtocol >> " + session.getAcceptedProtocol());
		System.out.println("getBinaryMessageSizeLimit >> " + session.getBinaryMessageSizeLimit());
		System.out.println("getId >> " + session.getId());
		System.out.println("getTextMessageSizeLimit >> " + session.getTextMessageSizeLimit());
		System.out.println("getAttributes >> " + session.getAttributes());
		System.out.println("getExtensions >> " + session.getExtensions());
		System.out.println("getHandshakeHeaders >> " + session.getHandshakeHeaders());
		System.out.println("getLocalAddress >> " + session.getLocalAddress());
		System.out.println("getPrincipal >> " + session.getPrincipal());
		System.out.println("getUri  >> " + session.getUri());
		System.out.println("=================================================================================");
	}
}












