package dto;

import lombok.Data;

@Data
public class Greeting {
	private String name;
	private String content;
	private String result;
	public Greeting(String name,String content,String result) {
		super();
		this.name = name;
		this.content = content;
		this.result = result;
	}
	public Greeting() {
	}
	
}
