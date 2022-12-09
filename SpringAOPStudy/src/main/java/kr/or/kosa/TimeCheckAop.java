package kr.or.kosa;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeCheckAop {

    private long beforeTime;
    private long afterTime;

//    @Pointcut("@annotation(com.gsm.chwijuntime.aop.timecheck.TimeCheck)") // -------- (4)
//    @Pointcut("executeion(* kr.or.kosa.AopClass.*(..))") // -------- (4)
//    @Pointcut("within(kr.or.kosa.*)") // -------- (4)
//    @Pointcut("execution(* kr.or.kosa..*.*(..))")
    @Pointcut("@annotation(TimeCheck)")
    public void TimeCheck() {}
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
    @Before("TimeCheck()")   // ------------- (5)
    public void before(JoinPoint joinPoint) {
    	System.out.println("Before AOP진입");
        beforeTime = System.currentTimeMillis();
    }

    @AfterReturning(pointcut = "TimeCheck()", returning = "result")   // ---------- (6)
    public void AfterReturning(JoinPoint joinPoint, Object result) {
    	System.out.println("After AOP진입");
        afterTime = System.currentTimeMillis();
        Log log = LogFactory.getLog(this.getClass());
        log.info("코드 수행 시간(ms) : " + (afterTime - beforeTime) + "ms");
        log.info("코드 수행 시간(s) : " + ((afterTime - beforeTime)/1000.0) + "s");
        log.info("result = " + result);     // ------------- (7)
    }

}