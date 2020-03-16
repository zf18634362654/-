package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.LBDate;
import org.service.LBService;
import org.serviceImp.LBServiceImp;

/**
 * Servlet implementation class borrowServlet
 */
@WebServlet("/borrowServlet")
public class borrowServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LBService service=new LBServiceImp();
		request.setCharacterEncoding("utf-8");
		  int sno=Integer.parseInt(request.getParameter("sno"));
	      int brid=Integer.parseInt(request.getParameter("brid"));
	      int bookid=Integer.parseInt(request.getParameter("bookId"));
	      String name=request.getParameter("name");
	      String bookName=request.getParameter("bookName");
	      String borrowDate1=request.getParameter("borrowDate");
	      String lendDate1=request.getParameter("lendDate");	  
	      
	    
	      
		     /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		      Date date = sdf.parse("2008-08-08");*/
	    //注意这里导入的包是java的还是sql的。
			
	      try {
	    	  Date borrowDate=new SimpleDateFormat("yyyy-MM-dd").parse(borrowDate1);
		     
		      
		      Date today=new Date();
		        Calendar cal1 = Calendar.getInstance();
		        cal1.setTime(today);
		        // 将分钟、秒、毫秒域清零
		        cal1.set(Calendar.HOUR_OF_DAY, 0);
		        cal1.set(Calendar.MINUTE, 0);
		        cal1.set(Calendar.SECOND, 0);
		        cal1.set(Calendar.MILLISECOND, 0);
		        Date nowReset = cal1.getTime();

		      
		      
		       System.out.println(nowReset); 
	    	  Date lendDate=new SimpleDateFormat("yyyy-MM-dd").parse(lendDate1);
	    	 
	    	  
	    	  
	    	  
	    	  if(lendDate.after(borrowDate)&&(!(borrowDate.before(nowReset)))) {
	    	  LBDate message=new LBDate(sno, brid, bookid, bookName, borrowDate, lendDate, name);
	    	  System.out.println(message);
	    	  if(service.borrowBook(message)) {
	    		  
	    		  System.out.println("借书成功！");
	    		  response.sendRedirect("queryBorrowBySnoServlet");
	    	  }
	    	  else {
	    		  
                response.setCharacterEncoding("utf-8");
	    		  
	    		  response.setContentType("text/html; charset=UTF-8");
	    		    PrintWriter out =response.getWriter();
	    		    out.println("该书库存不足,请选择其他书籍");
	    		  
	    	  }
	    	  
	    	  
	    	  }
	    	  else
	    	  {  
	    		  response.setCharacterEncoding("utf-8");
	    		  
	    		  response.setContentType("text/html; charset=UTF-8");
	    		    PrintWriter out =response.getWriter();
	    		    out.println("借书失败请检查日期是否正确");
	    	  }
	    		  
	      
	      } catch (ParseException e1) {
			// TODO Auto-generated catch block
	    	  response.setCharacterEncoding("utf-8");
    		  
    		  response.setContentType("text/html; charset=UTF-8");
    		    PrintWriter out =response.getWriter();
    		    out.println("借书失败请检查日期是否正确");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
