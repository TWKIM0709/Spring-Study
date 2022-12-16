package ncontroller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {
	private MemberDao memberdao;
	@Autowired
	public void setMemberdao(MemberDao memberdao) {
		this.memberdao = memberdao;
	}
	
	@GetMapping("join.htm")
	public String join() {
		return "joinus/join";
	}
	
	@PostMapping("join.htm")
	public String join(Member member) {
		System.out.println(member);
		try {
			memberdao.insert(member);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/index.htm";
		//http://localhost:8090/SpringMVC/joinus/join.htm
		//return "redirect:/index.htm" 처리하면
		//http://localhost:809/SpringMVC/index.htm
	}
}
