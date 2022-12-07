package kr.or.kosa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IntroController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("introcontroller 요청 실행 : handlerRequest 함수 실행");
		//handleRequest >> doGet/doPost 역할
		//ModelAndView >> 데이터를 담거나 View를 지정하는 객체
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","hong");
		mav.setViewName("intro");
		return mav;
	}

}
