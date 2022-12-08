package kr.or.kosa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("HelloController 요청 실행 : handlerRequest 함수 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","kosauser");
		
		
		
		
		mav.setViewName("hello");
		return mav;
	}

}
