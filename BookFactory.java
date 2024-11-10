package com.spring.BookStore;

import org.springframework.stereotype.Component;

@Component
public class BookFactory {
	public Book getBook(int id, String title, String author){
		return new Book(id, title, author);
	}
}
