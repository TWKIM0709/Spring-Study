package dao;

import java.util.List;

import dto.Greeting;
import dto.HelloMessage;

public interface ChatDao {
	public List<Greeting> getAllChat();
	public int insertChat(HelloMessage helloMessage);
}
