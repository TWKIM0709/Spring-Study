package ncontroller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.MemberService;
import vo.Member;

@Controller
@RequestMapping("/join/")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	//로그인 페이지 이동
	@RequestMapping(value="memberconfirm.htm",method=RequestMethod.GET)
	public String memberConfirm(){
		return "join.memberConfirm";
	}
	//로그인 처리
	@RequestMapping(value="memberconfirm.htm",method=RequestMethod.POST)
	public String memberConfirm(@RequestParam("password") String rawPassword,	Principal principal){
		String viewpage="";
		System.out.println("===========================");
		System.out.printf("======= %s =============",principal);
		
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
	
	//수정 페이지 이동
	@RequestMapping(value="memberupdate.htm", method=RequestMethod.GET)
	public String memberUpdate(Model model, Principal principal){
		Member member = service.getMember(principal.getName());
		model.addAttribute("member", member);
		return "joinus/memberUpdate";
	}
	//수정 페이지 처리
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
	//마이페이지 - 비밀번호 체크 화면 이동
	@GetMapping("mypage.htm")
	public String mypage(String pwd, Model model, Principal principal) {
		return "joinus/mypage";
	}
	//마이페이지 - 비밀번호 체크 화면 처리
	@PostMapping("mypage.htm")
	public String mypageCheck(String pwd, Model model, Principal principal) {
		Member member = service.getMember(principal.getName());
		String encodedPassword = member.getPwd(); //로그인한 사용자의 DB PWD 읽기
		//pwd를 입력했다면 체크한 결과값 , 입력하지 않았으면 false
		boolean result = (pwd != null) ?  bCryptPasswordEncoder.matches(pwd, encodedPassword) : false; 
		
		String url = result ? "redirect:memberupdate.htm" : "mypage.htm";
		return url;
	}
}
