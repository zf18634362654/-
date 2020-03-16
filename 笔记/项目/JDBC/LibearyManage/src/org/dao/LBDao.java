package org.dao;

import java.util.List;

import org.entity.LBDate;

public interface LBDao {
    boolean isBorrowed(int bookId) ;     
	boolean borrowBook(LBDate message);
	boolean lendBook(int brid);
	boolean updateBookNum(int i,int bookId);
	List<LBDate> queryBorrowBook(int sno);
	List<LBDate> queryAllBorrowBook();
	
	
	
	
}
