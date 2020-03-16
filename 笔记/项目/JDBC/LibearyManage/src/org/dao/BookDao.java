package org.dao;

import java.util.List;

import org.entity.Book;

public interface BookDao {
	public boolean isExist(String id);
	public  boolean addBook(Book book) ;	  
	public    List<Book> queryBookByName(String name);
	public    boolean deleteBookById(String id);
	public  boolean updateBookById(String id,Book book) ;
	public  List<Book>   queryAllBooks();
	public Book queryBookByID(String id);
	
	
	
}
