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
 * Servlet implementation class addServlet
 */
@WebServlet("/addServlet")
public class addBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		BookService  service=new BookServiceImp();
		String bookName=request.getParameter("bookName");
		
		String  id=request.getParameter("id");
		String author=request.getParameter("author");
		String publish=request.getParameter("publish");
		int num=Integer.parseInt(request.getParameter("num"));
		Book book=new Book(bookName, id, num, author, publish);
		if(service.addBook(book)) {
			response.sendRedirect("queryAllServlet");
			
		}
		else
			response.sendRedirect("m_bookAddFail.jsp");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
