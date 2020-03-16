package org.service;

import java.util.List;

import org.entity.Book;
import org.entity.LBDate;

public interface LBService {

	    
		boolean borrowBook(LBDate message);
		boolean lendBook(int id,int BookId);
		public List<LBDate> queryBorrowBook(int sno);
		int autoBrid();
		public List<LBDate> queryAllBorrowTable();
		public Book queryBookByID(String id);
	
}
