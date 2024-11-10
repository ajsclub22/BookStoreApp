package com.spring.BookStore;


import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookStoreApp {
	private static BookService service ;
	private static BookFactory bookFactory;
    public static void main(String[] args) {
        // Initialize Spring container and load beans from XML configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // Fetch beans from Spring context
//        Book book = (Book) context.getBean("book"); // Fetch the book bean
        service = context.getBean(BookServiceImpl.class); // Fetch the service bean
        bookFactory = (BookFactory) context.getBean(BookFactory.class);

        Scanner sc = new Scanner(System.in);
        System.out.println("------------Welcome to BookStore--------------------------");
        boolean running = true;
        while(running) {
        	System.out.println("Book Store Menu : ");
        	System.out.println("Enter 1 to add a book");
        	System.out.println("Enter 2 to delete a book");
        	System.out.println("Enter 3 to get a book");
        	System.out.println("Enter 4 to get all the books");
        	System.out.println("Enter 5 to Exit the Store ");
        	System.out.print("Select an Option : ");
        	int input = sc.nextInt();
        	switch(input) {
        	  case 1:
        		  int id;
        		  String title, author;
        		  System.out.print("\nEnter the Book id : ");
        		  id = sc.nextInt();
        		  System.out.print("Enter the Book title : ");
        		  title = sc.next();
        		  System.out.print("Enter the Book author name : ");
        		  author = sc.next();
        		  Book book = bookFactory.getBook(id, title, author);
        		  service.addBook(book);
        		  break;
        		  
        	  case 2:
        		  System.out.print("\nEnter the Book id to remove the Book from the store ");
        		  id = sc.nextInt();
        		  service.deleteBookById(id);
        		  break;
        		  
        	  case 3:
        		  System.out.print("\nEnter the Book id to get the Book from the store ");
        		  id = sc.nextInt();
        		  service.getBookById(id);
        		  break;
        		  
        	  case 4:
        		  service.getAllBooks();
        		  break;
        		 
        	  case 5:
        		  System.out.println("\nExiting fromt the Book Store ...");
        		  System.out.println("\n--------Tata Bye Bye !---------------");
        		  running = false;
        		  break;
        	
        	  default:
        		  System.out.println("Your re choose the wrong option please \n"
        		  		+ "select correct option among the Menu");  
	  
        	}
        	System.out.println("");
  
        }
        sc.close();
        ((AnnotationConfigApplicationContext) context).close();

    }
}

