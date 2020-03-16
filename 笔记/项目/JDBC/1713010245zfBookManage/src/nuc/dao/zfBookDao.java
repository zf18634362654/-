package nuc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import DButil.zf_Dbutil;
import nuc.bean.zfBook;



public class zfBookDao {
	public  List<zfBook>   queryAllCandidates() {
		List<zfBook> zfBooks=new ArrayList<zfBook>();
		zfBook zfBook=null;
		  ResultSet rs=null;
		try {
			
		
		
		String sql="select * from  zfbookstore";
		
			
			rs = zf_Dbutil.queryAll(sql, null);
			//执行Sql语句
			while(rs.next()) {
				String zftitle=rs.getString("zftitle");
				String zfauthor=rs.getString("zfauthor");
				String zfpublisher=rs.getString("zfpublisher");
				int zfbookId=rs.getInt("zfbookId");
				
				zfBook=new zfBook(zfpublisher,zftitle,zfbookId,zfauthor);
				zfBooks.add(zfBook);
				
			}
			return zfBooks;
			
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
					if(zf_Dbutil.pstmt!=null) zf_Dbutil.pstmt.close();
					if(zf_Dbutil.connection!=null) zf_Dbutil.connection.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		}
	
	
	
	}
	
	public  zfBook queryCandidateBySno(int zfbookId) {
		// TODO Auto-generated method stub
		zfBook zfBook;
		Object[] params= {zfbookId};
		String sql="select * from zfbookstore where zfbookId=?";
		ResultSet rs= zf_Dbutil.queryAll(sql, params);
		try {
			if(rs.next()) {
				
				String zfpublisher=rs.getString("zfpublisher");
				String zftitle=rs.getString("zftitle");
				String zfauthor=rs.getString("zfauthor");
				
				
				zfBook=new zfBook(zfpublisher,zftitle,zfbookId,zfauthor);
				System.out.println("2323");
				
				return zfBook;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
			
				try {
					if(rs!=null)	rs.close();
					if(zf_Dbutil.pstmt!=null) zf_Dbutil.pstmt.close();
					if(zf_Dbutil.connection!=null)  zf_Dbutil.connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		return null;
	}
	public  boolean addCandidate(zfBook zfBook) //添加学生
	{
		Object[] params= {zfBook.getTitle(),zfBook.getAuthor(),zfBook.getBookid(),zfBook.getPublisher()};
		 String sql="insert into zfbookstore (zftitle,zfauthor,zfbookId,zfpublisher)  values(?,?,?,?)";
	     return    zf_Dbutil.executeUpdate(sql, params);
	}
		
		

	public    boolean deleteStudentBySno(int bookID) //删除学生功能根据学号 
	{
		Object[] params= {bookID};
		String sql="delete from zfbookstore where zfbookId=? ";
		 return  zf_Dbutil.executeUpdate(sql, params);
		 
		
		
		
	}

	public  boolean updateStudentBySno(int number,zfBook zfBook) {
		Object[] params= {zfBook.getTitle(),zfBook.getAuthor(),zfBook.getPublisher(),zfBook.getBookid()};
		String sql="update zfbookstore set zftitle=?,zfauthor=?,zfpublisher=? where zfbookId=?";
		 return   zf_Dbutil.executeUpdate(sql, params);
	}
	
	
	




}

