package com.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.MemberDAO;
import com.model.MemberVO;

/*
 * 
 * GET , POST 
 * check.do
 * 화면 : memberSearch.jsp
 * 처리 : memberResult.jsp
 * public ModelAndView submit(){}
 * public String submit(Model model){} 
 * selectMemberById(id) 함수 사용
 */

@Controller
public class MemberSearchController {
	
	private MemberDAO memberdao;
	@Autowired  //by type
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}
	
	@RequestMapping(value="/check.do" , method=RequestMethod.GET)
	public String form() {
		return "memberSearch";
	}
	
	@RequestMapping(value="/check.do" , method=RequestMethod.POST)
	public ModelAndView submit(String id) {
		
		MemberVO membervo=null;
		ModelAndView mv =null;
		try {
			membervo = memberdao.selectMemberById(id);
			mv = new ModelAndView();
			mv.addObject("membervo",membervo);
			if(membervo != null) {
				mv.setViewName("memberResult");
			}else {
				mv.setViewName("memberSearch");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return mv;
	}
	/*
	@RequestMapping(value="/check.do" , method=RequestMethod.POST)
	public String submit(String id, Model model) throws SQLException {
		MemberVO membervo = memberdao.selectMemberById(id);
		model.addAttribute("membervo",membervo);
		String view = null;
		if(membervo != null) {
			view = "memberResult";
		}else {
			view = "memberSearch";
		}
		return view; 
	}
	*/
}







