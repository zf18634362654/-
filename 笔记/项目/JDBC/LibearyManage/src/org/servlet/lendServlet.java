package org.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.LBService;
import org.serviceImp.LBServiceImp;

/**
 * Servlet implementation class lendServlet
 */
@WebServlet("/lendServlet")
public class lendServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		LBService service=new LBServiceImp();
		int id=Integer.parseInt(request.getParameter("brid"));
		int bookId=Integer.parseInt(request.getParameter("bookId"));
		if(service.lendBook(id,bookId)) {
			System.out.println("还书成功！");
			request.setAttribute("lendF", 1);
			
		}
		else
			{System.out.println("该书不存在！");
			request.setAttribute("lendF", -1);
			}
		
		request.getRequestDispatcher("lendResult.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
