package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Book;
import com.service.IBookService;

@Controller
public class LoginController {

//추가 	@Secured 함수 권한 제어
	
	@Autowired
	public IBookService bookservice;
	
	@RequestMapping(value="login.do",method =RequestMethod.GET)
	public String success(ModelMap map){
		System.out.println("1. 책 추가하기");
		Book b1 = new Book("SPRINGBOOK", "kglim"); //name, owner
		//@PreAuthorize("hasRole('ROLE_WRITE')")
		bookservice.addBook(b1);
		System.out.println("add book :" + b1.getName() + "/" + b1.getOwner());
		
		System.out.println("2. 책 정보 가져오기");
		//@PostAuthorize("returnObject.owner == authentication.name")
		Book getbook = bookservice.getBook();
		System.out.println("get book : " + getbook.getName() + "/" + getbook.getOwner());
		
		//3. 책 삭제하기
		Book deletebook = new Book("ORACLEBOOK", "kglim");
		//@PreAuthorize("#book.owner == authentication.name")
		bookservice.deleteBook(deletebook);
		map.addAttribute("msg", "Done Successfuly"); //forward view msg 이름
		
		return "success"; //view 주소
	}
	
	@RequestMapping(value="/403.do", method={RequestMethod.GET,RequestMethod.POST})
	public String error403() {
		System.out.println("권한 설정");
	    return "error"; //view 주소
	}
}
