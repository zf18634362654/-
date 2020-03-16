package org.service;

import java.util.List;

import org.entity.Book;

public interface BookService {

	
	public  boolean addBook(Book book) ;	  
	public    List<Book> queryBookByName(String name);
	public    boolean deleteBook(String id);
	public  boolean updateBook(String id,Book book) ;
	public  List<Book>   queryAllBooks();
	public  int autoBookId();
	public  Book queryBookById(String id);
	
	
}
