package ncontroller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	//DAO
	private NoticeDao noticsdao;
	@Autowired
	public void setNoticsdao(NoticeDao noticsdao) {
		this.noticsdao = noticsdao;
	}
	
	// = = List = =
	@RequestMapping("notice.htm")
	public String noticeList(@RequestParam(value="pg", defaultValue = "1") String pg,
            @RequestParam(value ="f", defaultValue = "TITLE") String f,
            @RequestParam(value="p", defaultValue="%%") String p,
            Model model) {
		
		//DAO 작업
		List<Notice> list = null;
		try {
			list = noticsdao.getNotices(Integer.parseInt(pg), f, p);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();}
		
		//Spring  적용
		model.addAttribute("list",list);
		
		return "notice.jsp";
	}
	// = = Detail = = 
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq, Model model) {

		Notice notice = null;
		try {
			notice = noticsdao.getNotice(seq);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();	}
		
		model.addAttribute("notice", notice);
		
		return "noticeDetail.jsp";
	}
}
