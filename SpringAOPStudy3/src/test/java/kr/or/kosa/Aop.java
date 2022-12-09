package kr.or.kosa;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop {
//	@Before("execution(* com.sist.dao.EmpDAO.emp*(..))")
	@Before("execution(* kr.or.kosa.*.*(..))")
	   public void before()
	   {
	       System.out.println("before");
	   }
	   @After("execution(* kr.or.kosa.*.*(..))")
	   public void after()
	   {
	       System.out.println("after");
	   }
}
