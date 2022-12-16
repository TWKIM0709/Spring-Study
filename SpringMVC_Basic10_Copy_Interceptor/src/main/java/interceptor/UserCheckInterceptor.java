package interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  Object handler) {
		System.out.println("============ interceptor start ==========");
		String ck = (String)request.getSession().getAttribute("authority");
		boolean result = (ck != null) ? true : false; //로그인 했으면 true
		if(!result) { //로그인을 하지 않았으면 로그인(메인페이지)로 이동
			try {
				String url = request.getContextPath() + "/index.htm";
				System.out.println(url);
				response.sendRedirect(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("세션 : " + ck + " || 결과 : " + result);
		
		System.out.println("============ interceptor end ==========");
		return result; 
	}
}
