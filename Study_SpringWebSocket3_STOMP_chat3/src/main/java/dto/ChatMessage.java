package dto;

import lombok.Data;

@Data
public class ChatMessage { // {name : "태우"}
	private String name;
	private String content;
	private String roomid;
	public ChatMessage(String name,String Content,String roomid) {
		super();
		this.name = name;
		this.content = content;
		this.roomid = roomid;
	}
	public ChatMessage() {
	}
}
