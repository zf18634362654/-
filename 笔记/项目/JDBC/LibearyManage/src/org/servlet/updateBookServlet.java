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
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             
		BookService service=new BookServiceImp();
		request.setCharacterEncoding("utf-8");
		String bookName=request.getParameter("bookName");
		String  id=request.getParameter("id");
		String author=request.getParameter("author");
		String publish=request.getParameter("publish");
		int num=Integer.parseInt(request.getParameter("num"));
		
		
		Book book=new Book(bookName, id, num, author, publish);
		
		service.updateBook(id, book);
		response.sendRedirect("queryAllServlet");
		
		
		

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
