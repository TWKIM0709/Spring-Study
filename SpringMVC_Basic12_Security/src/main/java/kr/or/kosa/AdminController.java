package kr.or.kosa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@GetMapping(value = "admin/adminHome.do")
	public String home() {
		logger.info("Welcome AdminHome");
		return "admin/adminHome";
	}
}
