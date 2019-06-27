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
 * Servlet implementation class IsPass
 */
@WebServlet("/IsPass")
public class IsPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IsPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		UserDao ud = new UserDaoImpl();
		HttpSession session = request.getSession();

		
		List<User> userself = ud.getUser((String)session.getAttribute("username"));
		 User user=userself.get(0);
         String pass=user.getpass();
         if(pass.equals("0"))
         {
        	 request.getRequestDispatcher("/NewFile2.jsp").forward(request, response);
         }
         if(pass.equals("1"))
         {
        	 request.getRequestDispatcher("/NewFile.jsp").forward(request, response);
         }
         if(pass.equals("2"))
         {
        	 request.getRequestDispatcher("/NewFile1.jsp").forward(request, response);
         }
         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
