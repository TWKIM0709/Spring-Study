package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("========== 로그인 처리 PRE 인터셉터 시작 ==========");
		//로그인 처리 전에 로그아웃 처리
		HttpSession session = request.getSession();
		if(session.getAttribute("authority") != null) {
			session.removeAttribute("authority");
		}
		System.out.println("========== 로그인 처리 PRE 인터셉터 끝 ==========");
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		System.out.println("========== 로그인 처리 POST 인터셉터 시작 ==========");
		
		String authority = (String)modelAndView.getModelMap().get("authority");
		
		if(authority != null) {
			session.setAttribute("authority",authority);
			System.out.println("세션 등록");
		}
		System.out.println("========== 로그인 처리 POST 인터셉터 끝==========");
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
