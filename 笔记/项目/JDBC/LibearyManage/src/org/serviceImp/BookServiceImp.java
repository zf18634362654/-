package org.serviceImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.Dbutil.DButil;
import org.daoImp.BookDaoImp;
import org.entity.Book;
import org.service.BookService;

public class BookServiceImp implements BookService {
      BookDaoImp  dao=new BookDaoImp();
	 
	  
	
	
	@Override
	public boolean addBook(Book book) {
		  
		
		if(!dao.isExist(book.getId())) {
			System.out.println("serveice添加成功！");
			 return dao.addBook(book);
		}
					
         System.out.println("service 此书已存在！添加失败");		
		return false;
	}

	@Override
	public List<Book> queryBookByName(String name) {
         
		
		

		return dao.queryBookByName(name);
	}

	@Override
	public boolean deleteBook(String id) {
		// TODO Auto-generated method stub
		if(dao.isExist(id)) {
			System.out.println("serveice删除成功！");
			 return dao.deleteBookById(id);
		}
					
         System.out.println("service 此书不存在！删除失败");		
	
		
		return false;
	}

	@Override
	public boolean updateBook(String id, Book book) {
		// TODO Auto-generated method stub
		if(dao.isExist(id))
		{
			return dao.updateBookById(id, book);
			
		}
		
		return false;
	}

	@Override
	public List<Book> queryAllBooks() {
		// TODO Auto-generated method stub
		return dao.queryAllBooks();
	}

	@Override
	public int autoBookId() {
		// TODO Auto-generated method stub
		 Object[] params= {};
		String sql="select max(bookId) max  from book";
		ResultSet rs=DButil.queryAll(sql, params);
		if(rs!=null)
		{
			try {
				rs.next();
				System.out.println("书的最大的Id"+rs.getInt("max"));
				return rs.getInt("max")+1;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return 1;
	}

	@Override
	public Book queryBookById(String id) {
		
		
		
		
		return dao.queryBookByID(id);
	}

	

}
