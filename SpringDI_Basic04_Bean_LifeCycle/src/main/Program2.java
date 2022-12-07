package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Client2;

public class Program2 {

	public static void main(String[] args) {
		
	
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:ApplicationContext2.xml");
		Client2 client = context.getBean("client2", Client2.class);
		client.send();
		context.close();
		
		
	}

}
