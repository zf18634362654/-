package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Student;
import org.service.BookService;
import org.service.loginService;
import org.serviceImp.BookServiceImp;
import org.serviceImp.loginServiceImp;

/**
 * Servlet implementation class queryAllServlet
 */
@WebServlet("/queryAllServlet")
public class queryAllServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("utf-8");
		   BookService service=new BookServiceImp();
		   
		   
		   request.setAttribute("list", service.queryAllBooks());
              
		   if(loginServlet.count==-1) {
			
			
			
			   
		   request.getRequestDispatcher("s_queryAllBooks.jsp").forward(request, response);	
		   }
		   if(loginServlet.count==1)
		   {
			   int autoBookId=service.autoBookId();
				request.setAttribute("autoBookId", autoBookId);
			   
			   request.getRequestDispatcher("m_queryAllBooks.jsp").forward(request, response);	
			   
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
