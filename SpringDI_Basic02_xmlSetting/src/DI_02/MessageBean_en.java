package DI_02;

public class MessageBean_en implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("hello " + name);
	}

}
