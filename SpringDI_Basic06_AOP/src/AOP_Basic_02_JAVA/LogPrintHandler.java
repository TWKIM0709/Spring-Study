package AOP_Basic_02_JAVA;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

//보조 업무(공통관심) 클래스
//실 함수를 대신해서 처리 할 수 있는 기능 (대리함수) : invoke
//invoke 함수는 여러개의 다른 함수를 대리 한다 .....


public class LogPrintHandler  implements InvocationHandler {
    private Object target; //실 객체의 주소값
    public LogPrintHandler(Object target) {
		System.out.println("logPrintHandler 생성자 호출" + target);
		this.target = target;
	}
    
	
	
	//invoke 함수가 (ADD , MUL , SUB) 함수를 대리 합니다
	//마치 진짜 처럼 .....
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	//보조 업무를 가지고 있다
		System.out.println("invoke 함수 호출");
		System.out.println("method 함수명 : " + method);
		System.out.println("method parameter 값: " + Arrays.toString(args));
		
		//보조기능(공통관심)
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		//주업무 (실객체의 실제 함수 호출) : 주객체의 주함수 호출(ADD, MUL, SUB)
		int result = (int)method.invoke(this.target, args);
		
		
		//보조기능(공통관심)
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time Log Method : ADD]");
		log.info("[Time log Method: ] " + sw.getTotalTimeMillis());
		
		return result;
	}

}
