package nuc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nuc.bean.zfBook;
import nuc.dao.zfBookDao;


/**
 * Servlet implementation class QueryAllServlet
 */
@WebServlet("/QueryAllServlet")
public class zfQueryAllServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		zfBookDao zfBookDao=new zfBookDao();
		List<zfBook> zfBooks =zfBookDao.queryAllCandidates(); 
		System.out.println(zfBooks);
		
		request.setAttribute("candidates", zfBooks);

		request.getRequestDispatcher("displayAll.jsp").forward(request, response);
		System.out.println("2323");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
