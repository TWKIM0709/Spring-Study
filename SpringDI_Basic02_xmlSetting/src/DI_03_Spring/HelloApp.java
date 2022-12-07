package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		/*
		 * MessageBean message = new MessageBean_en(); message.sayHello("hong"); 
		 * message = new MessageBean_kr(); message.sayHello("hong");
		 */
		
		//Spring을 통해서 생성하고 조립하는 작업
		//1. 컨테이너 생성(메모리)
		//2. 컨테이너 안에서 생성될 객체를 만들고 주입하는 작업(xml) >> DI_03.xml

//		ApplicationContext context = new ClassPathXmlApplicationContext("DiConfig.xml");
//		RecordView view = (RecordView)context.getBean("view");
//		 >> 자동형변환 안됨
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
		MessageBean message = context.getBean("messagebean",MessageBean.class);
		
		message.sayHello("hong");
	}
}
