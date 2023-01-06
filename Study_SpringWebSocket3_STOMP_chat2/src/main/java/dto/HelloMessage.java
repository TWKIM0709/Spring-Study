package dto;

import lombok.Data;

@Data
public class HelloMessage { // {name : "태우"}
	private String name;
	private String content;
	public HelloMessage(String name,String Content) {
		super();
		this.name = name;
		this.content = content;
	}
	public HelloMessage() {
	}
}
