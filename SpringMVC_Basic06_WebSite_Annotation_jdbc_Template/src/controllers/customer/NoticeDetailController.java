package controllers.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

public class NoticeDetailController  implements Controller {

	public NoticeDetailController() {
		System.out.println("[NoticeDetailController]");
	}
	
	private NoticeDao noticsdao;
	@Autowired
	public void setNoticsdao(NoticeDao noticsdao) {
		this.noticsdao = noticsdao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//public Notice getNotice(String seq)
		
		String seq = request.getParameter("seq");
		Notice  notice = noticsdao.getNotice(seq);
		
		ModelAndView  mv = new ModelAndView();
		
		mv.addObject("notice", notice);
		mv.setViewName("noticeDetail.jsp");
		
		return mv;
	}

}
