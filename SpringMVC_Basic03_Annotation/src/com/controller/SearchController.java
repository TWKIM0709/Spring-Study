package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	/*
		parameter를 받는 방법
		1. 전통적인 방법 HttpServletRequest
		public ModelAndView searchExternal(HttpServletRequest request) {
				String str = request.getAttribute("name");
		}
		2. DTO 객체를 통한 전달 방법
		public ModelAndView searchExternal(MemberDto member) {
				조건
				DTO에 있는 member field 이름과 <input>태그의 name이 같아야함
		}
		3. 가장 만만한 방법
		public ModelAndView searchExternal(String id, String name, int age) {
			(DTO가 아니더라도)파라미터 이름과 <input> 태그의 name을 같게하면 자동 매핑된다. 
		}
		4. @RequestParam annotation 사용
			4.1 유효성 처리 가능
			4.2 기본값 처리
		5. REST 방식(비동기처리) method= get , post , put , delete
		@PathVariable >> /member/{memberid} >> /member/100
	*/
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(@RequestParam(value="query",defaultValue = "kosa")String query,
																	@RequestParam(value="p",defaultValue = "10") int p) {
		System.out.println("param query : " + query);
		System.out.println("param p: " + p);
		
		return new ModelAndView("search/external");
	}
}
