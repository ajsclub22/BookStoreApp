package com.spring.BookStore;
import java.util.List;
import java.util.Optional;
public interface BookRepository {
	public Optional<Book> addBook(Book book);
	public Optional<Book> deleteBookById(int id);
	public List<Book> getAllBooks();
	public Optional<Book> getBookById(int id);
}
