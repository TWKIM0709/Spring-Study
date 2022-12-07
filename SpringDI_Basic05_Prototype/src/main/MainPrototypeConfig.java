package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Spring.Client;
import Config.JavaConfigPrototype;

public class MainPrototypeConfig {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(JavaConfigPrototype.class);
		Client client =  context.getBean("client", Client.class);
		Client client2 = context.getBean("client", Client.class);
		System.out.println("client : " + client.toString());
		System.out.println("client2 : " + client2.toString());
	}

}
