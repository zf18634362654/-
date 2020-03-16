 package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Book;
import org.service.BookService;
import org.serviceImp.BookServiceImp;

/**
 * Servlet implementation class queryByNameServlet
 */
@WebServlet("/queryByNameServlet")
public class queryBookByNameServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BookService service=new BookServiceImp();
		String name=request.getParameter("bookName");
	
		
	
		
		
			if(service.queryBookByName(name)==null) {
				request.setAttribute("Yes", 1);
				request.getRequestDispatcher("s_queryBookByName.jsp").forward(request, response);
			}
			else
			{
				
					request.setAttribute("list", service.queryBookByName(name));
				request.getRequestDispatcher("s_queryBookByName2.jsp").forward(request, response);
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
