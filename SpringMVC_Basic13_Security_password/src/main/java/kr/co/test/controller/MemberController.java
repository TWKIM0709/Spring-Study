package kr.co.test.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.test.model.dto.Member;
import kr.co.test.service.MemberService;

@Controller
@RequestMapping("/join/")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="memberconfirm.htm",method=RequestMethod.GET)
	public String memberConfirm(){
		return "join.memberConfirm";
	}
	
	@RequestMapping(value="memberconfirm.htm",method=RequestMethod.POST)
	public String memberConfirm(@RequestParam("password") String rawPassword,	Principal principal){
		String viewpage="";
		
		//회원정보
		Member member = service.getMember(principal.getName());
		
		
		//DB에서 가져온 암호화된 문자열
		String encodedPassword = member.getPwd();
		
		System.out.println("rowPassword : "+rawPassword );
		System.out.println("encodepassword : " + encodedPassword);
		
		boolean result = bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
		
		if(result){
			viewpage="redirect:memberupdate.htm";
		}else{
			viewpage="redirect:memberconfirm.htm";
		}
		
		return viewpage;
	}
	
	
	@RequestMapping(value="memberupdate.htm", method=RequestMethod.GET)
	public String memberUpdate(Model model, Principal principal){
		Member member = service.getMember(principal.getName());
		model.addAttribute("member", member);
		return "join.memberUpdate";
	}
	
	@RequestMapping(value="memberupdate.htm", method=RequestMethod.POST)
	public String memberUpdate(Model model, Member member, Principal principal){
		
		Member updatemember = service.getMember(principal.getName());
		
		updatemember.setName(member.getName());
		updatemember.setCphone(member.getCphone());
		updatemember.setEmail(member.getEmail());
		updatemember.setPwd(bCryptPasswordEncoder.encode(member.getPwd()));
		service.updateMember(updatemember);
		return "redirect:/index.htm";
	}
}
