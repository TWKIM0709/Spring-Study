package kr.or.kosa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.Greeting;
import service.ChatService;

@RestController
@RequestMapping("/chatdata")
public class ChatRestfulController {
	@Autowired
	private ChatService service;
	
	@GetMapping
	public ResponseEntity<List<Greeting>> getChatList(){
		List<Greeting> list = new ArrayList<Greeting>();
		try {
			list = service.getAllChat();
			return new ResponseEntity<List<Greeting>>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Greeting>>(list,HttpStatus.BAD_REQUEST);
		}
	}
}
