package org.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.Dbutil.DButil;
import org.dao.LBDao;
import org.entity.Book;
import org.entity.LBDate;

public class LBDaoImp implements LBDao {
	

	@Override
	public boolean borrowBook(LBDate message) {
		// TODO Auto-generated method stub
		//util Date 转换为sql Date
				
		Object[] params= {message.getBrid(),message.getBookId(),message.getSno(),new java.sql.Date(message.getBorrowDate().getTime()),new java.sql.Date(message.getLendDate().getTime())};
		String sql="insert into bltable (brid,bookId,sno,borrowDate,lendDate)values (?,?,?,?,?) ";
		//new java.sql.Date(birthday.getTime()));
		
           System.out.println("2222222"+new java.sql.Date(message.getBorrowDate().getTime()));
		
		return DButil.executeUpdate(sql, params);
	}

	@Override
	public boolean lendBook(int brid) {
		// TODO Auto-generated method stub
		Object[] params={brid};
		String sql="delete from bltable where brid=?";
		
		
		
		return DButil.executeUpdate(sql, params);
	}

	@Override
	public boolean isBorrowed(int bookId) {
		// TODO Auto-generated method stub
		Object[]  params= {bookId};
		String sql="select num from book where bookId=?";
		ResultSet rs=DButil.queryAll(sql, params);
		if(rs!=null) {
			try {
				if(rs.next()) {
				if(rs.getInt(1)>0) {
					System.out.println("库存还有该书哦可以借出！");
					return true;
				}}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return false;
	}

	@Override
	public boolean updateBookNum(int i,int id) {
		// TODO Auto-generated method stub
		Object[] params= {i,id};
		String sql="update book set num=num+? where  bookId=? ";
		
		return DButil.executeUpdate(sql, params);
	}

	@Override
	public List<LBDate> queryBorrowBook(int sno) {
		// TODO Auto-generated method stub
		Object[] params= {sno};
		List<LBDate> lbs=new ArrayList<LBDate>();
		LBDate lb=null;
		String sql="select * from bltable,book,student where  bltable.bookId=book.bookId and bltable.sno=student.sno and bltable.sno=? ";
		ResultSet rs=DButil.queryAll(sql, params);
		
		
		try {
			while(rs.next()) {
			      
			      int brid=rs.getInt("brid");;
			      int bookid=rs.getInt("bookId");;
			      String name=rs.getString("sname");
			      String bookName=rs.getString("bookName");
			    
			      
			      Date borrowDate=rs.getDate("borrowDate");
			      System.out.println(borrowDate); 
			      Date lendDate=rs.getDate("lendDate");
			      
				
				 lb=new LBDate(sno, brid, bookid, bookName, borrowDate, lendDate, name);
				
			
				lbs.add(lb);
				
				
			}
			
			return lbs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		return null;
		
		
		
		
		//return null;
	}

	@Override
	public List<LBDate> queryAllBorrowBook() {
		
		List<LBDate> lbs=new ArrayList<LBDate>();
		LBDate lb=null;
		String sql="select * from bltable,book,student where  bltable.bookId=book.bookId and bltable.sno=student.sno  ";
		ResultSet rs=DButil.queryAll(sql, null);
		
		
		try {
			while(rs.next()) {
			      int sno=rs.getInt("sno");
			      int brid=rs.getInt("brid");;
			      int bookid=rs.getInt("bookId");;
			      String name=rs.getString("sname");
			      String bookName=rs.getString("bookName");
			    
			      
			      Date borrowDate=rs.getDate("borrowDate");
			      System.out.println(borrowDate); 
			      Date lendDate=rs.getDate("lendDate");
			      
				
				 lb=new LBDate(sno, brid, bookid, bookName, borrowDate, lendDate, name);
				
			
				lbs.add(lb);
				
				
			}
			
			return lbs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		return null;
		
		
		
	}



	
	
	
	
	
	
	
	
}
