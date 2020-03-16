package org.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.Dbutil.DButil;
import org.dao.BookDao;
import org.entity.Book;






public class BookDaoImp implements BookDao {

	@Override
	public boolean isExist(String id) {
       
		Object[] params= {id};
		String sql="select count(*) from book where bookId=?";
		ResultSet rs= DButil.queryAll(sql, params);
		try {
			if(rs.next()) {
				if(rs.getInt(1)>0) {
					return true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		
		Object[] params= {book.getId(),book.getBookName(),book.getAuthor(),book.getPublish(),book.getNum()};
		 String sql="insert into book (bookId,bookName,author,publish,num)  values(?,?,?,?,?)";
	     return    DButil.executeUpdate(sql, params);
	}

	

	@Override
	public boolean deleteBookById(String id) {
		// TODO Auto-generated method stub
		Object[] params= {id};
		String sql="delete from book where bookId=? ";
		 return  DButil.executeUpdate(sql, params);
	}

	@Override
	public boolean updateBookById(String id, Book book) {
		Object[] params= {book.getBookName(),book.getAuthor(),book.getPublish(),book.getNum(),id};
		String sql="update book set bookName=?,author=?,publish=?,num=? where  bookId=?";
		 return   DButil.executeUpdate(sql, params);
	}

	

	@Override
	public List<Book> queryBookByName(String name) {

		Book book;
		Object[] params= {name};
		List<Book> books=new ArrayList<Book>();
		String sql="select * from book where bookName=? ";
		
		ResultSet rs= DButil.queryAll(sql, params);
		System.out.println(sql);
		try {
			while(rs.next()) {
				
				String bookName=rs.getString("bookName");
				String  id=rs.getString("bookId");
				String author=rs.getString("author");
				String publish=rs.getString("publish");
				int num=rs.getInt("num");
				
				book=new Book(bookName, id, num, author, publish);
				books.add(book);
												
				
			}
			return books;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
			
				try {
					if(rs!=null)	rs.close();
					if(DButil.pstmt!=null) DButil.pstmt.close();
					if(DButil.connection!=null)  DButil.connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			 
		}
	
		
		
		
	}

	@Override
	public List<Book> queryAllBooks() {


		List<Book> books=new ArrayList<Book>();
		Book book=null;
		  ResultSet rs=null;
		try {
			
		
		//连接数据库
		String sql="select * from book ";
		
			
			rs = DButil.queryAll(sql, null);
			//执行Sql语句
			while(rs.next()) {
				String bookName=rs.getString("bookName");
				String  id=rs.getString("bookId");
				String author=rs.getString("author");
				String publish=rs.getString("publish");
				int num=rs.getInt("num");
				
				
				book=new Book(bookName, id, num, author, publish);
				books.add(book);
				
			}
			return books;
			
		}  catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		finally {
			
				try {
					if(rs!=null) rs.close();
					if(DButil.pstmt!=null) DButil.pstmt.close();
					if(DButil.connection!=null) DButil.connection.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		}
		
		
		
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
