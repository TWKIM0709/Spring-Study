package kr.or.kosa;

public class HelloMessage { // {name : "태우"}
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HelloMessage(String name) {
		super();
		this.name = name;
	}
	public HelloMessage() {
	}
	@Override
	public String toString() {
		return "HelloMessage [name=" + name + "]";
	}
	
}
