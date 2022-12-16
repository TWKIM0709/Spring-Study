package ncontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/userlogin.htm")
	public String userLogin(HttpServletRequest request,Model model) {
		model.addAttribute("authority","user");
		return "redirect:index.htm";
	}
	@RequestMapping("/adminlogin.htm")
	public String adminLogin(HttpServletRequest request,Model model) {
		model.addAttribute("authority","admin");
		return "redirect:index.htm";
	}
	@RequestMapping("/logout.htm")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:index.htm";
	}
}
