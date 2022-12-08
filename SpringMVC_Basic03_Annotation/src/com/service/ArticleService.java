package com.service;

import org.springframework.stereotype.Service;

import com.model.NewArticleCommand;

/*
@Service >> 너는 빈 객체로 생성되어야해
public class ArticleService {
	
}
조건..
xml 파일에
<context:component-scan base-package=""/> 있어야함

자동으로 bean 객체를 생성한다.
*/
public class ArticleService {
	public ArticleService() {
		System.out.println("ArticleService 생성자 호출");
	}
	public void writeArticle(NewArticleCommand command) {
		//DAO가 있다고 가정하고
		//+ Insert가 되었다고 가정하고
		System.out.println("글쓰기 작업 완료 : " + command);
	}
}
