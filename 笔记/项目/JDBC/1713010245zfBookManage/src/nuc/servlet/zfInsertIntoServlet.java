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
 * Servlet implementation class InsertIntoServlet
 */
@WebServlet("/InsertIntoServlet")
public class zfInsertIntoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		zfBookDao zfBookDao=new zfBookDao();
		boolean flag=false;
		request.setCharacterEncoding("utf-8");
		String publisher=request.getParameter("publisher");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		int    zfbookid=Integer.parseInt(request.getParameter("zfbookid"));
		zfBook zfBook=new zfBook(publisher, title, zfbookid, author);
		
	    flag=zfBookDao.addCandidate(zfBook);
		PrintWriter out =response.getWriter();
		if(flag) {
			response.sendRedirect("QueryAllServlet");
			
		}
		else {
			out.println("添加失败");
		}
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
