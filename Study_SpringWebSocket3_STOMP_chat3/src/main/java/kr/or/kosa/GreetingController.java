package kr.or.kosa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import dto.Greeting;
import dto.ChatMessage;
import service.ChatService;

@Controller
public class GreetingController {
	@Autowired
	public ChatService service;
	
	@MessageMapping("/{id}")
	@SendTo("/topic/{id}")
	public Greeting greeting(@DestinationVariable String id, ChatMessage message) throws Exception{
		System.out.println(message);
		boolean result = service.insertChat(message);
		
		Thread.sleep(500); // Hello 태우!
		
		return new Greeting(message.getName(),message.getContent(),(result) ? "success" : "fail");
	}
}
