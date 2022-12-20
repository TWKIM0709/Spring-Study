package com.service;

import com.bean.Book;


public class BookService  implements IBookService{

	@Override
	public void addBook(Book book) {
		System.out.println("success added book");
		
	}

	@Override
	public Book getBook() {
		Book book = new Book("JAVABOOK", "kglim");
		return book;
	}

	@Override
	public void deleteBook(Book book) {
		System.out.println("success Deleted book");
		
	}

}
