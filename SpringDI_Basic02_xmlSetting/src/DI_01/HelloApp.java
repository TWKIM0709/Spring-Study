package DI_01;

public class HelloApp {

	public static void main(String[] args) {
		MessageBean messagebean = new MessageBean();
		messagebean.sayHello("hong");
	}

}
/*
	요구사항
	1. 한글버전 >> 안녕 hong
	2. 영문버전 >> hello hong
	
	MessageBean_kr > 안녕 hong
	MessageBean_en > hello hong
	
	
*/