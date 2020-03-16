package org.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.LBDate;
import org.service.LBService;
import org.serviceImp.LBServiceImp;

/**
 * Servlet implementation class m_queryAllBorrowTableServlet
 */
@WebServlet("/m_queryAllBorrowTableServlet")
public class m_queryAllBorrowTableServlet extends HttpServlet {
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LBService service=new LBServiceImp();
        request.setAttribute("list", service.queryAllBorrowTable());
        request.getRequestDispatcher("m_queryAllBorrowTable.jsp").forward(request, response);
		 
		 
		 
  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
