package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;

@Controller
public class JoinController {

	//DB작업
	//DAO ...
	//member field 
	//인터페이스 타입 : 객체의 생성과 조립 (어떠한 부품도 ... 표준화 ... 다형성 ... interface
	private MemberDAO memberdao;

	@Autowired  //by type
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}
	
	//@RequestMapping(value="/join.do",method = RequestMethod.GET)
	@GetMapping(value="/join.do")
	public String form() {
		return "joinForm";
	}
   
   // 주의사항 : parameter 를 보내지 않으면 문제 없다
   // Default :  <a href="search/external.do">external.do</a><br>	
   // @RequestParam(value="p" , defaultValue="1") int p)
   // 그런데 : <a href="search/external.do?p">external.do</a><br>	가면
   // Failed to bind request element: org.springframework.beans.TypeMismatchException: Failed to convert value of type [java.lang.String] to required type [int]; nested exception is java.lang.NumberFormatException: For input string: ""
   
   //1. 해결방법 : 무조건 값을 보낸다   age=0
   //   @RequestParam(value="age") int age
   
   //2. @RequestParam(value="age" , required = false ) int age	
  
   //3. @RequestParam(value="age" , defaultValue = "1") Integer age	
   //   Type입을 객체타입으로 받는다 	
	
	//회원가입 , 게시판 글쓰기 : DTO 생성 : Parameter : DTO ...
	//?email=&age=
	//@RequestMapping(value="/join.do",method = RequestMethod.POST)
	@PostMapping(value="/join.do")
	public String sumbit(@RequestParam(value="id", required = true) String id,
						 @RequestParam(value="name") String name,
						 @RequestParam(value="pwd")  String pwd,
						 @RequestParam(value="email" ,defaultValue = "1@1") String email,
						 @RequestParam(value="age" , defaultValue = "1") Integer age) {

	
		System.out.println(id + "." + name + "." + pwd + "." + email + "." + age);
		String view = null;
		boolean joinresult = memberdao.memberInsert(id, name, pwd, email, age);
		
		if(joinresult) {
			view = "joinSuccess";
		}else {
			view = "joinForm";
		}
		
		return view;

	}
	
	
	
}







