package DI_05_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
//		MyBean mybean = new MyBean();
//		MyBean mybean2 = new MyBean("hong");
//		MyBean mybean3 = new MyBean("hong");
//
//		System.out.println(mybean +" , " +mybean2 +" , " +mybean3);
//		
//		Singleton single = Singleton.getInstance();
//		Singleton single2 = Singleton.getInstance();
//		Singleton single3 = Singleton.getInstance();
//
//		System.out.println(single+" , " +single2+" , " + single3);
//		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_05_Spring/DI_05.xml");
		//getBean 함수는 new가 아니다*****************
		MyBean m = context.getBean("mybean",MyBean.class);
		MyBean m2 = context.getBean("mybean2",MyBean.class);
		MyBean m3 = context.getBean("mybean3",MyBean.class);
		
		System.out.println(m +" , " +m2 +" , " +m3);

		Singleton single = context.getBean("single",Singleton.class);
		Singleton single2 = context.getBean("single",Singleton.class);
		Singleton single3 = context.getBean("single",Singleton.class);
		
		System.out.println(single +" , " +single2+" , " +single3);
		
		/*
			getBean() 
			1. 컨테이너 안에 있는 객체를 return ( new 가 아님! )
			2. return 타입은 Object ( downcasting 해아함)
			3. ** 스프링 컨테이너 안의 객체들은 default로 singleton을 가진다.
			4. ** 원한다면 new 역할도 할 수 있다. (거의 쓰지 않음) 
		*/
	}
}