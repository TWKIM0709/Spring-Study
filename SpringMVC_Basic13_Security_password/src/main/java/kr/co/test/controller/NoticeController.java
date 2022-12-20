package kr.co.test.controller;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.test.model.dto.Notice;
import kr.co.test.service.NoticeService;

@Controller
@RequestMapping("/notice/")
public class NoticeController {

	@Autowired
	private NoticeService service;
	
	@RequestMapping(value="noticeview.htm", method=RequestMethod.GET)
	public String viewBoard(
			@RequestParam(value="pg", defaultValue="1") int page,
			@RequestParam(value="f", defaultValue="TITLE") String field,
			@RequestParam(value="q", defaultValue="%%") String query,
			Model model){
		List<Notice> list = service.getNoticeList(page, field, query);
		model.addAttribute("list", list);
		return "notice.notice";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping("noticeDetail.htm")
	public String getNotice(String seq, Model model){
		Notice notice = service.getNotice(seq);
		model.addAttribute("notice", notice);
		return "notice.noticeDetail";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="noticeReg.htm", method=RequestMethod.GET)
	public String noticeReg(Model model){
		return "notice.noticeReg";
	}
	
	@RequestMapping(value="noticeReg.htm", method=RequestMethod.POST)
	public String noticeReg(Notice notice, HttpServletRequest request, Principal principal) 
			throws IOException, ClassNotFoundException, SQLException{
		String viewpage="";
		notice.setWriter(principal.getName());
				
		try{
			viewpage = service.noticeReg(notice, request);
		}catch(Exception e){
			e.printStackTrace();
			viewpage = "redirect:noticeview.htm";
		}
		
		return viewpage;
	}
	
	
}
