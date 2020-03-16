package org.serviceImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.Dbutil.DButil;
import org.dao.LBDao;
import org.daoImp.LBDaoImp;
import org.entity.Book;
import org.entity.LBDate;
import org.service.LBService;

public class LBServiceImp implements LBService {
    LBDao dao=new LBDaoImp();
	@Override
	public boolean borrowBook(LBDate message) {
		// TODO Auto-generated method stub
		if (dao.isBorrowed(message.getBookId())) {
			
			if (dao.borrowBook(message)) {
				
              return dao.updateBookNum(-1, message.getBookId());
			}
			
		}
		
		
		return false;
	}

	@Override
	public boolean lendBook(int id,int bookId) {
		// TODO Auto-generated method stub
		 if(dao.lendBook(id)) {
			 
		return	 dao.updateBookNum(1, bookId);
			 
		 }
		
		
	           	return false ;
 	}

	@Override
	public List<LBDate> queryBorrowBook(int sno) {
		// TODO Auto-generated method stub
		
		
		
		return dao.queryBorrowBook(sno);
	}
	
	@Override
	public int autoBrid() {
		// TODO Auto-generated method stub
		Object params[]= {};
		String sql="select max(brid)  as max from bltable  ";
		ResultSet rs=DButil.queryAll(sql, params);
		
		if(rs!=null) {
			try {
				rs.next();
				return rs.getInt("max")+1;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
			return 1;
		
		
		
	}
	
	public List<LBDate> queryAllBorrowTable(){
         LBDao dao=new LBDaoImp();		
		return   dao.queryAllBorrowBook();
	}

	@Override
	public Book queryBookByID(String id) {
		Object[] params= {id};
		String sql="select * from book where bookId=?";
		ResultSet rs= DButil.queryAll(sql, params);
		try {
			if(rs.next()) {
				if(rs.getInt(1)>0) {
					String bookName=rs.getString("bookName");
					
					String author=rs.getString("author");
					String publish=rs.getString("publish");
					int num=rs.getInt("num");
					Book book=new Book(bookName, id, num, author, publish);
					return  book;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	
	

}
