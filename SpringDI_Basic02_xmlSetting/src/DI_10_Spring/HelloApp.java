package DI_10_Spring;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		/*
		BookClient bookclient = new BookClient();
		
		Properties prop = new Properties();
		prop.setProperty("server", "192.168.0.29");
		prop.setProperty("connectiontimeout", "20");
		
		bookclient.setConfig(prop);
		bookclient.connect();
		*/
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_10_Spring/DI_10.xml");
		BookClient bookclient = context.getBean("bookClient",BookClient.class);
		bookclient.connect();
	}

}
