package com.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class SearchAllServlet
 */
@WebServlet("/SearchAllServlet")
public class SearchAllServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDao ud = new UserDaoImpl();
		HttpSession session = request.getSession();

		
		List<User> userall = ud.getUserAll();
          User user=userall.get(0);
          String username=user.getName();
          System.out.println(username);
          request.setAttribute("userall", userall);
		session.setAttribute("username", username);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
	
}
}
