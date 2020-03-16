package nuc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nuc.bean.zfBook;
import nuc.dao.zfBookDao;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class zfUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		zfBookDao a=new zfBookDao();
		String publisher=request.getParameter("publisher");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		System.out.println("-=-=-=-"+request.getParameter("bookid"));
	  int    zfbookid=Integer.parseInt(request.getParameter("bookid"));
		
		System.out.println("------"+zfbookid);
		zfBook zfBook=new zfBook(publisher, title, zfbookid, author);
		System.out.println("232323234455"+zfBook);
		boolean flag=false;
		flag=a.updateStudentBySno(zfbookid, zfBook);
		if(flag) {
			response.sendRedirect("QueryAllServlet");
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("删除失败");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
