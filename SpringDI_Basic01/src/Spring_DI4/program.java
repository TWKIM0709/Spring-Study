package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class program {

	public static void main(String[] args) {
		/*
		 * //생성 후.. NewRecordView view = new NewRecordView();
		 * 
		 * //놀다가 ...
		 * 
		 * //NewRecord 객체가 필요하면.. NewRecord record = new NewRecord(100,50,50);
		 * view.setRecode(record); //의존 객체의 주소 삽입(setter 함수를 통해서) view.print();
		 */
		
		/*
			(스프링은 자신만의 메모리 공간이 필요)
			1. SpringFramework 가 제공하는 컨테이너에 객체 생성 (메모리 생성 : IOC)
				>> ApplicationContext context = new ClassPathXmlApplicationContext
			2. 컨테이너를 만들고 그 메모리에 필요한 객체를 생성하고 조립(주입)한다... (그리고 자동으로 소멸)
				컨테이너가 생성되고 DiConfig.xml 를 읽고 컴파일한다...
				DiConfig.xml 컴파일 하면 bean 객체를 생성하고 필요한 객체를 주입받고 작업이 끝난다.
		*/
		//스프링은 개발자가 new를 하지 않는다?
		
		//스프링이 사용할 수 있는 메모리 공간 만들기
		//Spring이 필요한 메모리 공간을 생성하고 생성된 메모리에 DiConfig.xml을 읽어서 객체를 생성하는 코드
		ApplicationContext context = new ClassPathXmlApplicationContext("DiConfig.xml");
		//컨테이너 안에 생성되어 있는 객체를 골라서 가져옴
		RecordView view = (RecordView)context.getBean("view");
		
		view.input();
		view.print();
		// 에러 터짐 ... Caused by: java.lang.ClassNotFoundException: org.apache.commons.logging.LogFactory
	}

}