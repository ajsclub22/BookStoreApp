package com.spring.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
	int id;
	String title;
	String author;
	
	@Autowired
	public Book(@Value("1") int id, @Value("${book.title:Default Title}") String title, @Value("${book.author:Default Author}") String author) {
	      this.id = id;
		this.title = title;
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "{ " +this.id + " " + this.title + " " + this.author +" }";
	}
}
