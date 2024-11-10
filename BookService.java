package com.spring.BookStore;

public interface BookService {
	public void addBook(Book book);
	public void deleteBookById(int id);
	public void getAllBooks();
	public void getBookById(int id);
}
