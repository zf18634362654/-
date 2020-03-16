package org.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.BookService;
import org.serviceImp.BookServiceImp;

/**
 * Servlet implementation class queryBookByIdServlet
 */
@WebServlet("/queryBookByIdServlet")
public class queryBookByIdServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service=new BookServiceImp();  
		request.setCharacterEncoding("utf-8");
		  String id=request.getParameter("bookId");
		  request.setAttribute("book", service.queryBookById(id));
		   request.getRequestDispatcher("m_updateBook.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
