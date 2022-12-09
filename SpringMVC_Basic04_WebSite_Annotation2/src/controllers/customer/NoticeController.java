package controllers.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

/*
게시판 목록 조회 

controller  -> Model의존  (DAO , DTO) 가 필요

NoticeController 는   NoticeDao에 의존한다
필요하면 값을 받아야 해요 ... (DI , injection (생성자 , 함수(setter) 통해서 주입 받는다
*/
public class NoticeController  implements Controller {
	public NoticeController() {
		 System.out.println("[NoticeController]");
	}
	
	private NoticeDao noticsdao;
	@Autowired
	public void setNoticsdao(NoticeDao noticsdao) {
		this.noticsdao = noticsdao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	     //DAO 객체 사용
		//public List<Notice> getNotices(int page, String field, String query)
		
		String _page = request.getParameter("pg");
		String _field = request.getParameter("f");
		String _query = request.getParameter("p");
		  
		//default 값 설정
		int page = 1;
		String field="TITLE";
		String query = "%%";
		if(_page != null   && ! _page.equals("")) {
			page  = Integer.parseInt(_page);
		}
		
		if(_field != null   && ! _field.equals("")) {
			field = _field;
		}
		
		if(_page != null   && ! _page.equals("")) {
			page  = Integer.parseInt(_page);
		}
		
		if(_query != null   && ! _query.equals("")) {
			query = _query;
		}
		
		//DAO 작업
		List<Notice>  list = noticsdao.getNotices(page, field, query);
		
		
		//Spring  적용
		ModelAndView   mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("notice.jsp");
		
		
		
		return mv;
	}

}
