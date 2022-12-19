package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index.htm")
	public String index() {
		return "index";
		//return "/WEB-INF/views/index.jsp";
	}
}
