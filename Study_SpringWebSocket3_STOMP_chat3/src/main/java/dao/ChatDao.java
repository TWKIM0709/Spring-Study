package dao;

import java.util.List;

import dto.Greeting;
import dto.ChatMessage;

public interface ChatDao {
	public List<Greeting> getAllChat(String roomid);
	public int insertChat(ChatMessage helloMessage);
}
