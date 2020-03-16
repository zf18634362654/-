package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Book;
import org.service.LBService;
import org.serviceImp.LBServiceImp;

/**
 * Servlet implementation class borrowHelp
 */
@WebServlet("/borrowHelp")
public class borrowHelp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LBService service=new LBServiceImp();
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("bookId");
		Book book=service.queryBookByID(id);
		request.setAttribute("brid", service.autoBrid());
		request.setAttribute("bookId", id);
		request.setAttribute("bookName", book.getBookName());
		request.getRequestDispatcher("borrowBook.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
