package kr.or.kosa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatSocket extends TextWebSocketHandler{
	private static 	List<WebSocketSession> list = new ArrayList<WebSocketSession>();
	
	//연결 되었을 때 실행되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
		System.out.println("하나의 클라이언트가 연결 됨");
	}
	
	// 메세지를 보낼 때 호출되는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg = message.getPayload();//메세지를 받아서
		for(WebSocketSession s : list) {	//접속중인 모든 세선에 전송
			s.sendMessage(message);
		}
	}
	// 연결 끊었을 때 실행되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결 해제됨");
		list.remove(session);
	}
}












