package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*
	- 클라이언트가 요청
	1. 화면 주세요(글쓰기, 로그인 화면 등) : write.do , login.do ...
	2. 처리해주세요(글쓰기 입력 처리 , 로그인 완료 처리) : writeok.do , loginok.do ...
	
	요청 주소가 write.do >> 화면
					 writeok.do >> 처리 . . .
	
	- 클라이언트의 요청을 1개의 주소를 가지고 판단
	   > 근거 : 전송방식(get , post)
	   		GET 		>> 화면 >> view 제공
	   		POST	>> 처리 >> insert , update >> 화면 
*/
import org.springframework.web.servlet.ModelAndView;

import com.model.NewArticleCommand;
import com.service.ArticleService;
@Controller //이건 컨트롤러다
@RequestMapping("/article/newArticle.do") //매핑하겠다.
public class newArticleController {
	private ArticleService articleservice;
	@Autowired
	public void setArticleService(ArticleService articleservice) {
		this.articleservice = articleservice;
	}
//	@RequestMapping(method=RequestMethod.GET)
	@GetMapping //5.x.x 버전부터
	public String form() {
		//*** Spring에서... 함수의 return 타입이 String이면 >> view의 주소를 의미
		System.out.println("get");
		return "article/newArticleForm";
	}
	
	//1. 데이터를 받는 가장 전통적인 방법 >> HttpServletRequest request >> 코드량이 많아짐 . . . 
//	@RequestMapping(method=RequestMethod.POST)
	//옛날 코드
	/*@PostMapping //5.x.x 버전부터
	public ModelAndView submit(HttpServletRequest request) {
		System.out.println("post");
		NewArticleCommand article = new NewArticleCommand();
		article.setParentId( Integer.parseInt(request.getParameter("parentId")));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		
		//NewArticleController 가 service 필요해 
		this.articleservice.writeArticle(article);
		//처리완료
		
		ModelAndView mv = new  ModelAndView();
		mv.addObject("newArticleCommand", article);
		mv.setViewName("article/newArticleSubmitted");
		return mv;
	}*/
	
//	2. Spring 에서는 parameter 를 DTO 객체로 받기
//	2.1 자동화 >> 전제조건 >> input name == DTO 객체의 member filed 와 같게
/*	@PostMapping
	public ModelAndView submit(NewArticleCommand command) {
		//자동화
		//1. 자동으로 객체가 생성된다 (NewArticleCommand command = new NewArticleCommand ();
		//2. 넘어온 parameter 값을 DTO의 setter 함수로 자동 주입
		//3. 생성된 NewArticleCommand command 객체는 IOC 컨테이너 안에 자동 생성 id="newArticleCommand"
		
		this.articleservice.writeArticle(command);
		//처리완료
		
		ModelAndView mv = new  ModelAndView();
		mv.addObject("newArticleCommand", command);
		mv.setViewName("article/newArticleSubmitted");
		return mv;
	}*/
	@PostMapping
	public String submit(@ModelAttribute("Articledata") NewArticleCommand command) {
		System.out.println("post");
		this.articleservice.writeArticle(command);
		return "article/newArticleSubmitted";
	}
}
