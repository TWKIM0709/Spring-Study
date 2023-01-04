package kr.or.kosa;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration //Spring ConfigConfiguration 클래스임을 명시
@EnableWebSocketMessageBroker //웹소켓 메세지를 처리할 것임을 명시 
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		System.out.println("WebSocketConfig Broker 함수");
		//메시지 브로커가 [/topic] prefix가 붙은 수신처(해당 prefix를 구독중인)의 클라이언트로 메시지를 전달할 수 있도록 한다.
		registry.enableSimpleBroker("/topic");
		//GreetingController가 처리할 경로 설정
		//예를 들어, /app/hello는 GreetingController.greeting() 메서드가 처리하도록 매핑된 엔드포인트이다.
		registry.setApplicationDestinationPrefixes("/app");
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		System.out.println("WebSocketConfig Endpoint function");
		// registerStompEndpoint() 메서드는 /gs-guide-websocket 엔드포인트를 등록해서 웹소켓을 사용할 수 없는 경우
		// 웹소켓 대신 다른 전송방식을 사용할 수 있도록 SockJS 옵션을 활성화 한다.
		///gs-guide-websocket에 연결해서 사용 가능한 최적의 전송 방식(ex. 웹소켓, xhr-streaming, xhr-polling, etc)을 사용할 수 있도록 시도 한다.
		registry.addEndpoint("/gs-guide-websocket").setAllowedOriginPatterns("*").withSockJS();
	}
}
