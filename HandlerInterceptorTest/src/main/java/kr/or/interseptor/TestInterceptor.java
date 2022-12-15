package kr.or.interseptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor{

	public TestInterceptor() {
		System.out.println("Interceptor 생성");
	}
	//컨트롤러 시작 전
	//return false >> 컨트롤러 안감 / true >> 컨트롤러 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("============핸들러인터셉터 시작============");
		request.setAttribute("bt", System.currentTimeMillis());
		return true;
	}
	//컨트롤러 실행 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//뷰 전달 후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//시작한 시간 받아오기
		Long bt = (Long)request.getAttribute("bt");
		//현재 시간 받아오기
		long et = System.currentTimeMillis();
		
		System.out.println(request.getRequestURI() + "실행 시간 : "  + (bt - et));
		System.out.println("============핸들러인터럽터 끝============");
	}

}
