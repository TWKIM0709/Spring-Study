package com.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
이 방법은...
요청 하나당 controller 하나 필요
단점 : 서비스 요청 개수 만큼 controller 생성 
			목록  listController
			글쓰기 writeController... 
public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
*/

/*
 * @Controller
 * public class HelloController
 * 
 * >>메소드 단위로 매핑 할 수 있다.
 * 하나의 컨트롤러 안에 여러개의 함수를 만들어서 각각 매핑 
			목록  public void list()
			글쓰기 public void write()
 */
@Controller
public class HelloController {
	public HelloController() {
		System.out.println("HelloController 기본 생성자");
	}
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		System.out.println("[hello.do method ]");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("greeting",getGreeting());
		mv.setViewName("Hello");
		return mv;
	}
	
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String data = "";
		
		if(hour >=6 && hour<=10) {
			data = "학습시간";
		} else if(hour >=11 && hour<=13) {
			data = "배고픈 시간";
		} else if(hour >=14 && hour<=18) {
			data = "졸린 시간";
		} else {
			data = "go home";
		}
		
		return data;
	}
}
