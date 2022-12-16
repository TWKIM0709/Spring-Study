package interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		System.out.println("============ AdminInterceptor start ==========");
		String ck = (String)request.getSession().getAttribute("authority");
		boolean result = true;
		if(ck != null) {
			if(!ck.equals("admin")) { //어드민이 아니면 로그인(메인페이지)로 이동
				String url = request.getContextPath() + "/index.htm";
				System.out.println(url);
				try {
					response.sendRedirect(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				result = false;
			}
		}
		System.out.println("세션 : " + ck + " || 결과 : " + result);
		System.out.println("============ AdminInterceptor end ==========");
		return result; 
	}
}
