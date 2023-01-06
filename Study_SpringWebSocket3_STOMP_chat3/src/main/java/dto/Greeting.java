package dto;

import lombok.Data;

@Data
public class Greeting {
	private String chat_name;
	private String chat_content;
	private String chat_result;
	public Greeting(String chat_name,String chat_content,String chat_result) {
		super();
		this.chat_name = chat_name;
		this.chat_content = chat_content;
		this.chat_result = chat_result;
	}
	public Greeting() {
	}
	
}
