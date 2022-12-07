package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import Spring.Client;

public class MainPrototype {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:ApplicationContext.xml");
		Client client =  context.getBean("client", Client.class);
		Client client2 = context.getBean("client", Client.class);
		
		//************************************
		//scope="prototype"
		//getbean() 호출시 객체 생성
		
		
		System.out.println("client : " + client.toString());
		System.out.println("client2 : " + client2.toString());
		//context.close();
	}

}
