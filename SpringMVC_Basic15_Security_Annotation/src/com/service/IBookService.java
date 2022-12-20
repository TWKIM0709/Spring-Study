package com.service;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import com.bean.Book;

public interface IBookService {

	@PreAuthorize("hasRole('ROLE_WRITE')")
	void addBook(Book book);
	
	
	@PostAuthorize("returnObject.owner == authentication.name")
	Book getBook();
	/*
	   현재 로그인한 계정 : hong 
	   Book b = new Book("구운몽","kglim")
	   
	   "kglim" != "hong" > false 접근권한 예외 
	   return  b; 
	*/
	
	/*
	 Book bo = new Book("홍길동전","kglim")
	 (bo.kglim == "kglim")
	 delelteBook(bo)
	 */
	@PreAuthorize("#book.owner == authentication.name")
	void deleteBook(Book book);
}









