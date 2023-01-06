package service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ChatDao;
import dto.Greeting;
import dto.ChatMessage;

@Service
public class ChatService {
	@Autowired
	private SqlSession sqlsession;
	
	public List<Greeting> getAllChat(String roomid){
		List<Greeting> list = null;
		
		try {
			ChatDao dao = sqlsession.getMapper(ChatDao.class);
			list = dao.getAllChat(roomid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean insertChat(ChatMessage message) {
		boolean result = false;
		try {
			if(message.getContent().equals("error")) {throw new Exception();} // content 내용이 error 라면 예외를 일으킴 ( 테스트용 ) 
			ChatDao dao = sqlsession.getMapper(ChatDao.class);
			int row = dao.insertChat(message);
			result = (row > 0) ? true : false; 
		} catch (Exception e) {
			System.out.println("예외발생");
			result = false;
		}
		
		return result;
	}
}
