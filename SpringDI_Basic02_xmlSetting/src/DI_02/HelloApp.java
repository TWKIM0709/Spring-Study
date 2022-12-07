package DI_02;

public class HelloApp {

	public static void main(String[] args) {
		MessageBean message = new MessageBean_en();
		message.sayHello("hong");
		message = new MessageBean_kr();
		message.sayHello("hong");
	}
}
