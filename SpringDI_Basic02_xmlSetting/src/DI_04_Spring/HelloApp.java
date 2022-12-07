package DI_04_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
//		MessageBeanImpl messagebean = new MessageBeanImpl("hong");
//		messagebean.setGreeting("hello");
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_04_Spring/DI_04.xml");
		MessageBean messagebean = context.getBean("m1",MessageBean.class);
		
		messagebean.sayHello();
	}
}