package com.spring.BookStore;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepo ;
	
	@Autowired
	public BookServiceImpl(BookRepository repo) {
		bookRepo = repo;
	}
	@Override
	public void addBook(Book book) {
		Optional<Book> result= bookRepo.addBook(book);
		
		if(result.isPresent()) System.out.println(book + " added successfully in the Store");
		else System.out.println(book +" not added in Store Becoz a "
				+ "Book is already present at that Id");
	}
	
	@Override 
	public void deleteBookById(int id) {
		Optional<Book> result= bookRepo.deleteBookById(id);
		if(result.isEmpty()) System.out.println("There is no book exists with id : "+ id 
				+ " in the Store.");
		else System.out.println(result.get() + " Successfully removed from the store");
	}
	
	@Override
	public void getBookById(int id) {
		Optional<Book> result = bookRepo.getBookById(id);
		if(result.isEmpty()) System.out.println("There is no book exists with id : "+ id 
				+ " in the Store.");
		else System.out.println(result.get() + "is available the store");
		}
	
	@Override
	public void getAllBooks() {
		List<Book> bookList = bookRepo.getAllBooks();
		if(bookList.isEmpty()) System.out.println("There is no Book Available in the Store.");
		else {
			System.out.println("The Book List : ");
			for(Book book : bookList) {
				System.out.println(book);
			}
			System.out.println("Book List are Ended");
		}
	}
}
