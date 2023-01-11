package kr.or.kosa;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import org.springframework.stereotype.Component;

@Component
public class EmailCodeMap {
	private static Map<String, Integer> map= new HashMap<String, Integer>();

	public EmailCodeMap() {
		System.out.println("EmailCodeMap 생성됨");
		map = new HashMap<String, Integer>();
	}
	public static  void addMap(String email, int code) {
		map.put(email, code);
		
		new Timer(true).schedule(new TestTimerTask(email), 1000 * 20);
	}
	public static  void removeMap(String email) {
		map.remove(email);
	}
	
	
	public static void printTest() {
		System.out.println(map);
	}
	
	public  static boolean checkCode(String email, int code) {
		boolean result = (map.get(email).equals(code)) ? true : false;
		if(result) map.remove(email);
		return result;
	}
}
