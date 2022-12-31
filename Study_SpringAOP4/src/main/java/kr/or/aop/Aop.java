package kr.or.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop {
	@Pointcut("* kr.or.kosa..*(..)")
	public void cut() {}
	
	@Before("cut()")
	public void before() {
		System.out.println("before");
	}
}
/*
	executeion([returnType]  [package].[className].[methodName] ([매개변수리스트] ))
	
	execution( * com.exam.*Service.find*(..))
	: com.exam 하위의 Serivce로 마치는 클래스의 리턴타입 유형에 관계없이,
	
	find 로 시작하는 메서드명을 가진 매개변수 0~* 인 메서드를 AOP 적용대상으로 한다
	[ 사용 예 ]
	
	execution(String com.exam.service..*.search*(..))
	com.exam.service 패키지 또는 그 하위 패키지의 모든 클래스 중 String 리턴타입인 search 이름으로 시작하는 모든 메서드를 적용대상으로 한다
	within(com.exam.service.*)
	com.exam.service 패키지 하위의 모든 클래스의 모든 메서드를 대상으로 한다
	bean(*Service)
	IOC 컨테이너에 관리되는 bean이름이 Service로 끝나는 bean의 모든 메서드를 대상으로 한다
*/ 
