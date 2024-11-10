package com.spring.BookStore;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BookRepositoryImpl implements BookRepository {
	
	private Map<Integer, Book> bookMap ;
	
	public BookRepositoryImpl() {
		bookMap = new HashMap<>();
	}
	
	@Override 
	public Optional<Book> addBook(Book book) {
		int id = book.id;
		if(bookMap.containsKey(id)) return Optional.empty();
		bookMap.put(id, book);
		return Optional.of(book);
		
	}
	
	@Override 
	public Optional<Book> deleteBookById(int id) {
		Book book = bookMap.remove(id);
		return Optional.ofNullable(book);
	}
	
	@Override 
	public Optional<Book> getBookById(int id) {
		Book book = bookMap.get(id);
		return Optional.ofNullable(book);
	}
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		for(int key:bookMap.keySet()) {
			bookList.add(bookMap.get(key));
		}
		return bookList;
	}
	
}
