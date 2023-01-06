package kr.or.kosa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import dto.Greeting;
import dto.HelloMessage;
import service.ChatService;

@Controller
public class GreetingController {
	@Autowired
	public ChatService service;
	
	@MessageMapping("/hello/{id}")
	@SendTo("/topic/greetings/{id}")
	public Greeting greeting(@DestinationVariable String id, HelloMessage message) throws Exception{
		
		boolean result = service.insertChat(message);
		
		Thread.sleep(1000); // Hello 태우!
		
		return new Greeting(message.getName(),message.getContent(),(result) ? "success" : "fail");
	}
}
