package com.servlet;

import java.io.IOException;
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
 * Servlet implementation class BaoMingservlet
 */
@WebServlet("/BaoMingservlet")
public class BaoMingservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao ud = new UserDaoImpl();
		HttpSession session = request.getSession();
		
		ud.setPass((String)session.getAttribute("username"));
		System.out.println(1);
		System.out.println((String)session.getAttribute("username"));
		System.out.println(1);
		request.getRequestDispatcher("/baomingsuccess.jsp").forward(request, response); 
		
	}
}