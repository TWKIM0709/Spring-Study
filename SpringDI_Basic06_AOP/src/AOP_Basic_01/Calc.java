package AOP_Basic_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class Calc {
	/*
	 * 간단한 사칙 연산 프로그램
	 * 주 관심(업무) : 사칙연산
	 * 보조관심 (공통관심) : 연산에 걸린 시간
	 * */
	
	public int add(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		int result = x+y;
		
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[TIME LOG METHOD : ADD]");
		log.info("[TIME LOG METHOD : ]" + sw.getTotalTimeMillis());
		return result;
	}
	public int Mul(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		int result = x*y;
		
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[TIME LOG METHOD : MUL]");
		log.info("[TIME LOG METHOD : ]" + sw.getTotalTimeMillis());
		return result;
	}
}
