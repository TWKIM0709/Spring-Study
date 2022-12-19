package kr.or.kosa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@GetMapping(value = "/login/loginForm.do")
	public String login() {
		logger.info("Welcome Login Form");
		return "login/loginForm";
	}
	@GetMapping(value = "/login/accessDenied.do")
	public String loginDenied() {
		logger.info("Welcome accessDenied");
		return "login/accessDenied";
	}
}
