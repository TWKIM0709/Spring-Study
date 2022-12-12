package com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;

import jdk.nashorn.internal.objects.annotations.Getter;

/*
 *  로그인 화면 : GET 요청 > loginForm
 *  로그인 처리 : POST 요청 > id, pwd > memberCheck 검증 > loginSuccess(빈페이지)
 *  
 *  조건 : 인증 성공하면 session 담기 > [기존 servlet 과 동일]
 * 
 *  public void test(HttpSession session){
 *    session.setAttribute("USERID", "hong")
 *  }
 * 
 */
@Controller
@RequestMapping("/login.do")
public class LoginController {
   
	@Autowired   //memberfield 주입 가능 >> 일반적으로는 setter 주입을 선호한다.
	private MemberDAO memberdao;
	
	
	
//	@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public String form() {
		return "loginForm";
	}
	
//	@RequestMapping(method=RequestMethod.POST)
	@PostMapping
	public String submit(
			              @RequestParam(value="id") String id,
			              @RequestParam(value="pwd") String pwd,
			              HttpSession session	//HttpSession 객체 얻어오기
			             ) throws SQLException 
	{
		String view = null;
		boolean isMember = memberdao.memberCheck(id, pwd);
		if(isMember) {
			session.setAttribute("USERID",id); //
			view = "loginSuccess";
		}else {
			view = "loginForm";
		}
		return view;
	}
}











