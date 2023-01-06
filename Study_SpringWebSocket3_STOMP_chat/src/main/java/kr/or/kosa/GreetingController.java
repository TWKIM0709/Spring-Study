package kr.or.kosa;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception{
		System.out.println("Greeting Controller greeting function");
		
		// 서비스(DB작업)를 실행시키고 성공하면 true / 실패하면 false
		
		Thread.sleep(1000); // Hello 태우!
		
		
		return new Greeting("Hello " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}
}
