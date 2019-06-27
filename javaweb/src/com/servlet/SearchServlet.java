package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDao ud = new UserDaoImpl();
		HttpSession session = request.getSession();

		
		List<User> userself = ud.getUser((String)session.getAttribute("username"));
		 User user=userself.get(0);
         String pass=user.getpass();
		request.setAttribute("userself", userself);
		System.out.println(userself);
		if(pass.equals("0"))
		{
		request.getRequestDispatcher("/show1.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/show2.jsp").forward(request, response);
		}
}
}